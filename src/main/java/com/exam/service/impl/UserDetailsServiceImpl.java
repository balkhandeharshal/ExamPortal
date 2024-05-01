package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.repo.UserRepositary;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepositary userRepositary;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepositary.findByUsername(username);
		if(user==null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user found !!");
		}
		
		return user;
	}

	
}
