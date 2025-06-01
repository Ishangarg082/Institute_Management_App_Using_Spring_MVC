package com.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@ComponentScan(basePackages = "com")
public class MainController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}


	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		 HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
	      Cookie[] cookies = request.getCookies();
	      	
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("auth")) {
	                    cookie.setMaxAge(0);
	                    cookie.setPath("/");
	                    response.addCookie(cookie);
	                    break;
	                }
	            }
	        }
		return "logout";
	}


	@RequestMapping(value = "/Upload", method = RequestMethod.POST)
	public String Upload(@RequestParam("file") MultipartFile file) {
		System.out.println("Inside Upload");
		if (!file.isEmpty()) {
			System.out.println("Uploaded file: " + file.getOriginalFilename());
		} else {
			System.out.println("No file uploaded.");
		}
		return "FileUpload";
	}

	@RequestMapping(value = "/FileUpload")
	public String FileUpload() {
		System.out.println("Inside FileUpload");
		return "FileUpload";
	}
}
