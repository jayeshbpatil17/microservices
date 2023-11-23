package com.patil.UserService.services;

import java.util.List;

import com.patil.UserService.Entity.User;


public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	//dleete user
	
	//update User

}
