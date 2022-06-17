package com.exam.portal.service;

import java.util.Set;

import com.exam.portal.model.User;
import com.exam.portal.model.UserRole;

public interface UserService {

	//create user
	public User createUser(User user,Set<UserRole> userRoles);
}
