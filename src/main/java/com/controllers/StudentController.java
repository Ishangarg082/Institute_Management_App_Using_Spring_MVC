package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.CourseEnrolled;
import com.entity.Fee;
import com.entity.Student;
import com.service.AttendanceService;
import com.service.CourseEnrolledService;
import com.service.FeeService;
import com.service.MarksService;
import com.service.StudentService;
import com.util.StudentDataMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@ComponentScan(basePackages = "com")
public class StudentController {
	
	@Autowired
	private StudentService ss;
	
	@Autowired
	private AttendanceService atservice;
	
	@Autowired
	private MarksService mservice;
	
	@Autowired
	private CourseEnrolledService ces;
	
	@Autowired
	private FeeService fs;
	
	@Autowired
	private StudentDataMapper sdm;
	
	@RequestMapping("/studentlogin")
	public String studentlogin(HttpServletRequest request, Model model) {
		return "studentlogin";
	}

	@RequestMapping(value = "/studentconsole", method = RequestMethod.POST)
	public String studentconsole(HttpServletResponse response, HttpServletRequest request,@RequestParam("rollnumber") String rollnumber, @RequestParam("pass") String password,
			Model m) {
		String viewName = "";

		Student student = ss.get(rollnumber);
		if (student != null && student.getPass().equals(password)) {
			request.getSession().setAttribute("user", student);
			Cookie cookie = new Cookie("auth","true");
			cookie.setPath("/ims");
			cookie.setMaxAge(10*60);
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			response.addCookie(cookie);
			
			Cookie usercookie = new Cookie("userId",rollnumber);
			cookie.setPath("/ims");
			cookie.setMaxAge(10*60);
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			response.addCookie(usercookie);
			Fee fees = fs.getFeeByRoll(rollnumber);

			if (fees.getPaid().equals("no")) {
				m.addAttribute("feemessage", "Kindly Pay your fees at fee counter to avoid penalties");
			} else {
				m.addAttribute("feemessage", "Sit back and relax.");
			}
			m.addAttribute("fee", fees);
			m.addAttribute("student", student);
			m.addAttribute("courseData", sdm.assemble(rollnumber));
			viewName = "studentconsole";
		} else {
			viewName = "studentlogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;
	}

	@RequestMapping("/students")
	public String students(HttpServletRequest request, Model model) {
		List<Student> student = ss.getAllStudents();
		model.addAttribute("Student", student);
		return "students";
	}

	@RequestMapping("/deletestudent")
	public String deletstudent(Model model, @RequestParam("rollnumber") String rollnumber) {
		ss.deleteStudent(rollnumber);
		ces.deleteEnrollmentByRollNumber(rollnumber);
		mservice.delete(rollnumber);
		atservice.deleteAttendance(rollnumber, rollnumber, rollnumber);
		model.addAttribute("Student", ss.getAllStudents());
		return "students";
	}

	@RequestMapping("/addstudent")
	public String addstudent(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("name") String name, @RequestParam("branch") String branch,
			@RequestParam("address") String address, @RequestParam("age") String age,
			@RequestParam("pass") String pass) {
		ss.add(rollnumber, name, age, branch, pass, address);
		model.addAttribute("student", ss.get(rollnumber));
		return "addstudentinfo";
	}

	@RequestMapping("/addstudentinfo")
	public String addstudentinfo(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("courseid1") String courseid1, @RequestParam("courseid2") String courseid2,
			@RequestParam("courseid3") String courseid3, @RequestParam("courseid4") String courseid4,
			@RequestParam("courseid5") String courseid5, @RequestParam("fee") String fee,
			@RequestParam("feestatus") String feestatus) {
		fs.add(rollnumber, fee, feestatus);
		List<CourseEnrolled> list = ces.getAllEnrollments();
		int i = list.size();
		ces.addEnrollment(i + 1, courseid5, rollnumber);
		ces.addEnrollment(i + 2, courseid4, rollnumber);
		ces.addEnrollment(i + 3, courseid3, rollnumber);
		ces.addEnrollment(i + 4, courseid2, rollnumber);
		ces.addEnrollment(i + 5, courseid1, rollnumber);
		model.addAttribute("Student", ss.getAllStudents());
		return "students";
	}

	@RequestMapping("/editstudent")
	public String editstudent(Model model, @RequestParam("rollnumber") String rollnumber) {
		model.addAttribute("student", ss.get(rollnumber));
		return "updatestudent";
	}

	@RequestMapping("/updatestudent")
	public String updatestudent(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("name") String name, @RequestParam("branch") String branch,
			@RequestParam("address") String address, @RequestParam("age") String age,
			@RequestParam("pass") String pass) {

		ss.update(rollnumber, name, age, branch, address, pass);
		model.addAttribute("Student", ss.getAllStudents());
		return "students";
	}

}
