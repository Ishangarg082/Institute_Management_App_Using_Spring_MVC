package com.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class Authentication {
	@Autowired
	private HttpServletRequest request;

	public boolean isCookieValid() {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				
				if (cookie.getName().equals("auth") && cookie.getValue().equals("true")) {
					return true;
				}if(cookie.getName().equals("userid") && cookie.getValue().equals(null)) {
					return false;
				}
			}
		}
		return false;
	}

	public boolean isSessionValid() {
		Object user = request.getSession().getAttribute("user");
		return user != null;
	}

	@Around("execution(* com.controller..*(..))")
	public Object validateAccess(ProceedingJoinPoint joinPoint) throws Throwable {
		String uri = request.getRequestURI();
		if (uri.contains("login") || uri.contains("logout") || uri.equals("/") || uri.equals("/home")) {
			return joinPoint.proceed();
		}
		if (!isCookieValid() || !isSessionValid()) {
			if (uri.startsWith("/admin") || uri.contains("admin")) {
				return "redirect:/admin";
			} else if (uri.startsWith("/student") || uri.contains("student")) {
				return "redirect:/studentlogin";
			} else {
				return "redirect:/stafflogin";
			}
		}
		return joinPoint.proceed();
	}

}
