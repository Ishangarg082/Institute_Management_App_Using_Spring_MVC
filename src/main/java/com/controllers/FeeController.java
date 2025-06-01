package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.util.FeeDataMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@ComponentScan(basePackages = "com")
public class FeeController {


	@Autowired
	private FeeDataMapper fdm;
	@RequestMapping("/fees")
	
	public String fees(HttpServletRequest request, Model model) {
		return "fees";
	}

	@RequestMapping("/feebyroll")
	public String feebyroll(@RequestParam("rollnumber") String rollnumber, Model model) {
		model.addAttribute("fees", fdm.assembler(rollnumber));
		return "fees";
	}

	@RequestMapping("/feebystatus")
	public String feebystatus(@RequestParam("status") String status, Model model) {
		model.addAttribute("fees", fdm.assembler2(status));
		return "fees";
	}

}
