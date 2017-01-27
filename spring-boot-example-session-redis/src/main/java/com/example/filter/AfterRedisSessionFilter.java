package com.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// @Component
@Order(SessionRepositoryFilter.DEFAULT_ORDER + 10)
public class AfterRedisSessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("after redis session: ");
		System.out.println("request: " + request);
		System.out.println("response: " + response);
		System.out.println("session: " + session);
		filterChain.doFilter(request, response);
	}

}
