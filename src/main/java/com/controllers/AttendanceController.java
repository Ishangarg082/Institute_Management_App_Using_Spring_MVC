package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Attendance;
import com.service.AttendanceService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@ComponentScan(basePackages = "com")
public class AttendanceController {
	@Autowired
	private AttendanceService atservice;

	@RequestMapping("/attendance")
	public String attendance(HttpServletRequest request, Model model) {
		return "attendance";
	}

	@RequestMapping("/addattendance")
	public String addattendance(@RequestParam("rollnumber") String rollnumber, @RequestParam("date") String date,
			@RequestParam("courseid") String courseid, @RequestParam("status") String status, Model model) {
		List<Attendance> att = atservice.getAllAttendance();
		int i = att.size();
		atservice.addAttendance(i+1, rollnumber, date, status, courseid);
		return "attendance";
	}

	@RequestMapping("/updateattendance")
	public String updateattendance(@RequestParam("attendanceid") int attendanceid,
			@RequestParam("rollnumber") String rollnumber, @RequestParam("date") String date,
			@RequestParam("courseid") String courseid, @RequestParam("status") String status, Model model) {
		atservice.updateAttendance(rollnumber, date, status, attendanceid, courseid);
		return "attendance";
	}

	@RequestMapping("/searchattbyroll")
	public String searchattbyroll(HttpServletRequest request, Model model,
			@RequestParam("rollnumber") String rollnumber) {
		model.addAttribute("attendance", atservice.getAttendanceByRoll(rollnumber));
		return "attendance";
	}

	@RequestMapping("/searchattbycourse")
	public String searchattbycourse(HttpServletRequest request, Model model,
			@RequestParam("courseid") String courseid) {
		model.addAttribute("attendance", atservice.getAttendanceByCourse(courseid));
		return "attendance";
	}

	@RequestMapping("deleteAttendance")
	public String deleteAttendance(@RequestParam("rollnumber") String rollnumber,
			@RequestParam("courseid") String courseid, @RequestParam("date") String date) {
		atservice.deleteAttendance(rollnumber, courseid, date);
		return "attendance";
	}

}
