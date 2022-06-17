package com.exam.portal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.portal.model.User;
import com.exam.portal.model.UserRole;
import com.exam.portal.repo.RoleRepository;
import com.exam.portal.repo.UserRepository;
import com.exam.portal.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		return null;
	}

}
