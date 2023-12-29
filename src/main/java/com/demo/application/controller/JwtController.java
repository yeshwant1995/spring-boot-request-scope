package com.demo.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.config.JwtTokenUtil;
import com.demo.application.model.UserDetailsRequestScope;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class JwtController {

	private final JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsRequestScope userDetailsRequestScope;

	public JwtController(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}
	

	@GetMapping("/generateJwtToken")
	public ResponseEntity<String> generateJwtTokne() throws JsonProcessingException {

		String token = jwtTokenUtil.generateToken();

		return new ResponseEntity<>(token, HttpStatus.OK);
	}
	
	@GetMapping("/extract")
	public ResponseEntity<Void> verifyJwtToken(){
		
		System.out.println("userDetailsRequestScope "+ userDetailsRequestScope);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
