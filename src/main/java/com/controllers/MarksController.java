package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.MarksService;
import com.util.MarksDataMapper;

@Controller
@ComponentScan(basePackages = "com")
public class MarksController {
	
	@Autowired
	private MarksDataMapper mdm;
	
	@Autowired
	private MarksService mservice;
	

	@RequestMapping("/marks")
	public String marks(Model model) {
		return "marks";
	}

	@RequestMapping("searchMarksbyroll")
	public String searchMarksbyroll(@RequestParam("rollnumber") String rollnumber, Model model) {
		
		model.addAttribute("mark", mdm.assembler(rollnumber));
		return "marks";
	}

	@RequestMapping("searchMarksbycourse")
	public String searchMarksbycourse(@RequestParam("courseid") String courseid, Model model) {

		model.addAttribute("mark", mdm.assembler2(courseid));
		return "marks";
	}

	@RequestMapping("addMarks")
	public String addMarks(@RequestParam("rollnumber") String rollnumber, @RequestParam("courseid") String courseid,
			@RequestParam("marks") int marks) {
		mservice.addMark(rollnumber, courseid,marks);
		return "marks";
	}

	@RequestMapping("deleteMarks")
	public String deleteMarks(@RequestParam("marksid") int marksid) {
		mservice.deleteMarks(marksid);
		return "marks";
	}

	@RequestMapping("editmarks")
	public String editmarks(@RequestParam("marksid") int marksid, Model model) {
		model.addAttribute("marks", mservice.getall());
		return "updatemarks";
	}

	@RequestMapping("updatemarks")
	public String updatemarks(@RequestParam("marksid") int marksid, @RequestParam("rollnumber") String rollnumber,
			@RequestParam("courseid") String courseid, @RequestParam("marks") String marks) {
		mservice.updateMarks(marksid, rollnumber, courseid, marksid);
		return "marks";
	}

}
