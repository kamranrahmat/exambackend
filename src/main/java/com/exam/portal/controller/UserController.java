package com.exam.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.model.User;
import com.exam.portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		//this.userService.createUser(user, userRoles)
		return null;
	}
	
}
