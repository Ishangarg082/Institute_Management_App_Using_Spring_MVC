package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@ComponentScan(basePackages = "com")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@PostMapping("/adminconsole")
	public String adminConsole(HttpServletResponse response, HttpServletRequest request,@RequestParam("userid") String userId, @RequestParam("pass") String password,
			Model model) {
		User user = userService.getUser(userId);
		if (user != null && user.getPass().equals(password) && "admin".equals(user.getRole())) {
			request.getSession().setAttribute("user", user);
			Cookie cookie = new Cookie("auth","true");
			cookie.setPath("/ims");
			cookie.setMaxAge(10*60);
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			response.addCookie(cookie);
			
			Cookie usercookie = new Cookie("userId",userId);
			cookie.setPath("/ims");
			cookie.setMaxAge(10*60);
			cookie.setHttpOnly(true);
			cookie.setSecure(true);
			response.addCookie(usercookie);
			
			model.addAttribute("users", userService.getAllUsers());
			return "adminconsole";
		} else {
			model.addAttribute("errormessage", "Wrong Credentials");
			return "admin";
		}
	}

	@PostMapping("/adduser")
	public String addUser(Model model, @RequestParam("username") String username, @RequestParam("name") String name,
			@RequestParam("pass") String pass, @RequestParam("role") String role) {
		userService.addUser(username, pass, role, name);
		model.addAttribute("users", userService.getAllUsers());
		return "adminconsole";
	}

	@PostMapping("/deleteuser")
	public String deleteUser(Model model, @RequestParam("userId") String username) {
		userService.deleteUser(username);
		model.addAttribute("users", userService.getAllUsers());
		return "adminconsole";
	}

	@GetMapping("/edituser")
	public String editUser(@RequestParam("userId") String userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		return "updateuser";
	}

	@PostMapping("/updateuser")
	public String updateUser(Model model, @RequestParam("username") String username, @RequestParam("name") String name,
			@RequestParam("pass") String pass, @RequestParam("role") String role) {
		userService.updateUser(username, name, role, pass);
		model.addAttribute("users", userService.getAllUsers());
		return "adminconsole";
	}
}
