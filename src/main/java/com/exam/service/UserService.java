package com.exam.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.UserRepositary;

public interface UserService {

	
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception ; 
	
	// get user by user name
	public User getUser(String username);
	
	//delete by user id
	public void deleteUser(Long userId);
	
	//edit by user
	public User editUser(Long userId);
	
}
