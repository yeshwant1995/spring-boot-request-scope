package com.demo.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.application.model.UserDetails;
import com.demo.application.model.UserDetailsRequestScope;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	UserDetailsRequestScope userDetailsRequestScope;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String token = request.getHeader("token");

		if (token != null) {

			String jsonString = jwtTokenUtil.extractJwtToken(token);

			UserDetails userDetails = objectMapper.readValue(jsonString, UserDetails.class);

			userDetailsRequestScope.setUser(userDetails.getUserName(), userDetails.getUserId());
		}

		return true;
	}

}
