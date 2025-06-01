package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@ComponentScan(basePackages = "com")
public class StaffController {

	@Autowired
	private UserService us;

	@RequestMapping("/stafflogin")
	public String stafflogin(HttpServletRequest request, Model model) {
		return "stafflogin";
	}

	@RequestMapping(value = "/staffconsole", method = RequestMethod.POST)
	public String staffconsole(HttpServletResponse response, HttpServletRequest request,@RequestParam("userid") String userId, @RequestParam("pass") String password, Model m) {
		String viewName = "";
		User user = us.getUser(userId);
		if (user != null && user.getPass().equals(password)) {
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
			m.addAttribute("user", user);
			viewName = "staffconsole";
		} else {
			viewName = "stafflogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}
		return viewName;
	}

}
