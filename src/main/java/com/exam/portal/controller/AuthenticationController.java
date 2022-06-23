package com.exam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.config.JwtUtils;
import com.exam.portal.model.JwtRequest;
import com.exam.portal.model.JwtResponse;
import com.exam.portal.service.impl.UserDetailsServiceImpl;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		
		String token= this.jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	private void authenticate(String username,String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
	}
	
}
