package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.CourseService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@ComponentScan(basePackages = "com")
public class CourseController {

	@Autowired
	private CourseService cs;

	@RequestMapping("/courses")
	public String courses(HttpServletRequest request, Model model) {
		model.addAttribute("courses", cs.getAllCourses());
		return "courses";
	}

	@RequestMapping("/addcourse")
	public String addcourse(Model model, @RequestParam("CourseId") String courseid,
			@RequestParam("CourseName") String name) {
		cs.addCourse(courseid, name);
		model.addAttribute("courses", cs.getAllCourses());
		return "courses";
	}

	@RequestMapping("/deletecourse")
	public String deletecourse(Model model, @RequestParam("courseid") String courseid) {
		cs.deleteCourse(courseid);
		return "courses";
	}

	@RequestMapping("/editcourse")
	public String editcourse(Model model, @RequestParam("courseid") String courseid) {
		model.addAttribute("courses", cs.getCourse(courseid));
		return "updatecourse";
	}

	@RequestMapping("/updatecourse")
	public String updatecourse(Model model, @RequestParam("CourseId") String courseid,
			@RequestParam("CourseName") String name) {
		cs.updateCourse(courseid, name);
		model.addAttribute("courses", cs.getAllCourses());
		return "courses";
	}

}
