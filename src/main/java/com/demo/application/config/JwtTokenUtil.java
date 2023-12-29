package com.demo.application.config;

import java.io.Serializable;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.demo.application.model.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	SecretKey key = Jwts.SIG.HS256.key().build();

	public String generateToken() throws JsonProcessingException {

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		UserDetails userDetails = new UserDetails(1L, "yeshwant");
		String json = ow.writeValueAsString(userDetails);

		String jwt = Jwts.builder().subject(json).signWith(key).compact();
		return jwt;
	}

	public String extractJwtToken(String token) {
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
	}

}
