package com.security;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class NoCacheFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpresponse = (HttpServletResponse) response;
        httpresponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpresponse.setHeader("Pragma", "no-cache");
        httpresponse.setDateHeader("Expires", 0);
        chain.doFilter(request, response);
	}

}
