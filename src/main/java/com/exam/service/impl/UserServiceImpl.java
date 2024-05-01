package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exam.helper.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepositary;
import com.exam.repo.UserRepositary;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepositary userRepositary;
	
	@Autowired
	private RoleRepositary roleRepositary;
//creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
	
		User local = this.userRepositary.findByUsername(user.getUsername());
		if(local !=null) {
			System.out.println("User is already there !!");
			throw new UserFoundException();
		}
		else {
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepositary.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepositary.save(user);
		}
		return local;
	}
	
	//geting user by username
	@Override
	public User getUser(String username) {
		
		return userRepositary.findByUsername(username);
	}

	//delete user by user id
	@Override
	public void deleteUser(Long userId) {
		this.userRepositary.deleteById(userId);
		
	}

	@Override
	public User editUser(Long userId) {
		
		return null;
	}

	//editUser by id
	
	
	@ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

}
