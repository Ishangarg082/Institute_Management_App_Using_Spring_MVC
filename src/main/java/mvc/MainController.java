package mvc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private StudentDao StudentDao;

	@Autowired
	private CourseEnrolledDao ced;

	@Autowired
	private CourseDao cd;

	@Autowired
	private AttendanceDao atdao;

	@Autowired
	private MarksDao markdao;

	@Autowired
	private FeeDao feedao;

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/admin")
	public String admin(Model m) {
		return "admin";
	}

	@RequestMapping(value = "/adminconsole", method = RequestMethod.POST)
	public String adminconsole(@RequestParam("userid") String userId, @RequestParam("pass") String password, Model m) {
		String viewName = "admin";
		User user = userDao.get(userId);
		List<User> users = userDao.getusers();

		if (user != null && user.getPass().equals(password) && user.getRole().equals("admin")) {
			m.addAttribute("users", users);
			viewName = "adminconsole";
		} else {
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;
	}

	@RequestMapping("/stafflogin")
	public String stafflogin(HttpServletRequest request, Model model) {
		return "stafflogin";
	}

	@RequestMapping(value = "/staffconsole", method = RequestMethod.POST)
	public String staffconsole(@RequestParam("userid") String userId, @RequestParam("pass") String password, Model m) {
		String viewName = "";

		User user = userDao.get(userId);

		if (user != null && user.getPass().equals(password)) {
			m.addAttribute("user", user);
			viewName = "staffconsole";
		} else {
			viewName = "stafflogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;

	}

	@RequestMapping("/studentlogin")
	public String studentlogin(HttpServletRequest request, Model model) {
		return "studentlogin";
	}

	@RequestMapping(value = "/studentconsole", method = RequestMethod.POST)
	public String studentconsole(@RequestParam("rollnumber") String rollnumber, @RequestParam("pass") String password,
			Model m) {
		String viewName = "";

		Student student = StudentDao.get(rollnumber);
		if (student != null && student.getPass().equals(password)) {
			List<CourseEnrolled> enrolledCourses = ced.getCoursesByRollNumber(rollnumber);
			List<StudentConsoleData> scd = new ArrayList<>();

			List<Attendance> attendanceList = atdao.getbyroll(rollnumber);
			List<Marks> marks = markdao.getmarksByRollNumber(rollnumber);
			Fee fees = feedao.getbyroll(rollnumber);

			for (CourseEnrolled enrolled : enrolledCourses) {
				Course course = cd.get(enrolled.getCourseid());
				if (course != null) {
					Hibernate.initialize(course.getName());

					StudentConsoleData data = new StudentConsoleData();
					data.setCourseid(course.getCourseid());
					data.setCoursename(course.getName());

					int totalClasses = 0;
					int totalPresent = 0;

					for (Attendance attendance : attendanceList) {
						if (attendance.getCourseid().equals(course.getCourseid())) {
							totalClasses++;
							if (attendance.isPresent()) {
								totalPresent++;
							}
						}
					}

					data.setTotalclasses(totalClasses);
					data.setTotalpresent(totalPresent);

					for (Marks markiterator : marks) {
						if (markiterator.getCourseid().equals(course.getCourseid())) {
							data.setMarks(markiterator.getMarks());
						}
					}
					scd.add(data);
				}

			}

			if (fees.getPaid().equals("no")) {
				m.addAttribute("feemessage", "Kindly Pay your fees at fee counter to avoid penalties");
			} else {
				m.addAttribute("feemessage", "Sit back and relax.");
			}
			m.addAttribute("fee", fees);
			m.addAttribute("student", student);
			m.addAttribute("courseData", scd);
			viewName = "studentconsole";
		} else {
			viewName = "studentlogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;
	}

	@RequestMapping("/courses")
	public String courses(HttpServletRequest request, Model model) {
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "courses";
	}

	@RequestMapping("/students")
	public String students(HttpServletRequest request, Model model) {
		List<Student> student = StudentDao.getall();
		model.addAttribute("Student", student);
		return "students";
	}

	@RequestMapping("/deletestudent")
	public String deletstudent(Model model, @RequestParam("rollnumber") String rollnumber) {
		StudentDao.delete(rollnumber);
		ced.delete(rollnumber);
		feedao.delete(rollnumber);
		markdao.delete(rollnumber);
		atdao.delete(rollnumber);
		List<Student> student = StudentDao.getall();
		model.addAttribute("Student", student);
		return "students";
	}

	@RequestMapping("/addstudent")
	public String addstudent(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("name") String name, @RequestParam("branch") String branch,
			@RequestParam("address") String address, @RequestParam("age") String age,
			@RequestParam("pass") String pass) {
		StudentDao.insert(rollnumber, name, age, branch, address, pass);
		Student student = StudentDao.get(rollnumber);
		model.addAttribute("student", student);
		return "addstudentinfo";
	}

	@RequestMapping("/addstudentinfo")
	public String addstudentinfo(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("courseid1") String courseid1, @RequestParam("courseid2") String courseid2,
			@RequestParam("courseid3") String courseid3, @RequestParam("courseid4") String courseid4,
			@RequestParam("courseid5") String courseid5, @RequestParam("fee") String fee,
			@RequestParam("feestatus") String feestatus) {
		feedao.add(rollnumber, fee, feestatus);
		List<CourseEnrolled> list = ced.getAll();
		int i = list.size();
		ced.add(i + 1, courseid5, rollnumber);
		ced.add(i + 2, courseid4, rollnumber);
		ced.add(i + 3, courseid3, rollnumber);
		ced.add(i + 4, courseid2, rollnumber);
		ced.add(i + 5, courseid1, rollnumber);
		List<Student> student = StudentDao.getall();
		model.addAttribute("Student", student);
		return "students";
	}

	@RequestMapping("/editstudent")
	public String editstudent(Model model, @RequestParam("rollnumber") String rollnumber) {
		Student student = StudentDao.get(rollnumber);
		System.out.print(student);
		model.addAttribute("student", student);
		return "updatestudent";
	}

	@RequestMapping("/updatestudent")
	public String updatestudent(Model model, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("name") String name, @RequestParam("branch") String branch,
			@RequestParam("address") String address, @RequestParam("age") String age,
			@RequestParam("pass") String pass) {

		StudentDao.update(rollnumber, name, age, branch, address, pass);
		List<Student> student = StudentDao.getall();
		model.addAttribute("Student", student);
		return "students";
	}

	@RequestMapping("/marks")
	public String marks( Model model) {
		return "marks";
	}

	@RequestMapping("/fees")
	public String fees(HttpServletRequest request, Model model) {
		return "fees";
	}

	@RequestMapping("/feebyroll")
	public String feebyroll(@RequestParam("rollnumber") String rollnumber, Model model) {
		Fee fee = feedao.getbyroll(rollnumber);

		FeeData fees = new FeeData();
		fees.setFees(fee.getFees());
		fees.setPaid(fee.getPaid());
		fees.setRollnumber(fee.getRollnumber());
		fees.setname(StudentDao.get(fee.getRollnumber()).getName());
		fees.setBranch(StudentDao.get(fee.getRollnumber()).getBranch());
		List<FeeData> feedata = new ArrayList<>();
		feedata.add(fees);
		model.addAttribute("fees", feedata);
		return "fees";
	}

	@RequestMapping("/feebystatus")
	public String feebystatus(@RequestParam("status") String status, Model model) {
		List<Fee> fee = feedao.getbypaid(status);
		List<FeeData> feedata = new ArrayList<>();
		for (Fee item : fee) {
			FeeData fees = new FeeData();
			fees.setFees(item.getFees());
			fees.setPaid(item.getPaid());
			fees.setRollnumber(item.getRollnumber());
			fees.setname(StudentDao.get(item.getRollnumber()).getName());
			fees.setBranch(StudentDao.get(item.getRollnumber()).getBranch());
			feedata.add(fees);
			model.addAttribute("fees", feedata);

		}
		return "fees";
	}

	@RequestMapping("/attendance")
	public String attendance(HttpServletRequest request, Model model) {
		return "attendance";
	}

	@RequestMapping("/searchattbyroll")
	public String searchattbyroll(HttpServletRequest request, Model model,
			@RequestParam("rollnumber") String rollnumber) {
		List<Attendance> att = atdao.getbyroll(rollnumber);
		model.addAttribute("attendance", att);
		return "attendance";
	}

	@RequestMapping("/searchattbycourse")
	public String searchattbycourse(HttpServletRequest request, Model model,
			@RequestParam("courseid") String courseid) {
		List<Attendance> att = atdao.getbycourse(courseid);
		model.addAttribute("attendance", att);
		return "attendance";
	}

	@RequestMapping("/adduser")
	public String adduser(Model model, @RequestParam("username") String username, @RequestParam("name") String name,
			@RequestParam("pass") String pass, @RequestParam("role") String role) {
		userDao.add(username, pass, role, name);
		List<User> user = userDao.getusers();
		model.addAttribute("users", user);
		return "adminconsole";
	}

	@RequestMapping("/deleteuser")
	public String deleteuser(Model model, @RequestParam("userId") String username) {
		userDao.remove(username);
		List<User> user = userDao.getusers();
		model.addAttribute("users", user);
		return "adminconsole";
	}

	@RequestMapping("/addcourse")
	public String addcourse(Model model, @RequestParam("CourseId") String courseid,
			@RequestParam("CourseName") String name) {
		cd.add(courseid, name);
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "courses";
	}

	@RequestMapping("/deletecourse")
	public String deletecourse(Model model, @RequestParam("courseid") String courseid) {
		cd.delete(courseid);
		ced.delete(courseid);
		atdao.deletecourse(courseid);
		markdao.deletecourse(courseid);
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "courses";
	}

	@RequestMapping("/editcourse")
	public String editcourse(Model model, @RequestParam("courseid") String courseid) {
		Course course = cd.get(courseid);
		model.addAttribute("courses", course);
		return "updatecourse";
	}

	@RequestMapping("/updatecourse")
	public String updatecourse(Model model, @RequestParam("CourseId") String courseid,
			@RequestParam("CourseName") String name) {
		cd.update(courseid, name);
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "courses";
	}

	@RequestMapping("/edituser")
	public String editUser(@RequestParam("userId") String userId, Model model) {
		User user = userDao.get(userId);
		model.addAttribute("user", user);
		return "updateuser";
	}

	@RequestMapping("/updateuser")
	public String updateuser(Model model, @RequestParam("username") String username, @RequestParam("name") String name,
			@RequestParam("pass") String pass, @RequestParam("role") String role) {
		userDao.update(username, name, role, pass);
		List<User> users = userDao.getusers();
		model.addAttribute("users", users);
		return "adminconsole";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logout";
	}
}
