package com.patil.UserService.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patil.UserService.Entity.User;
import com.patil.UserService.exceptions.ResourceNotFoundException;
import com.patil.UserService.repositories.UserRepository;
import com.patil.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		//generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {

		//return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on Server !! : "+userId));

		Optional<User> userOptional =userRepository.findById(userId);

	    // If the user is present, do something with it
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        return user;
	        // Do something with the user
	    } else {
	        // Handle the case where the user is not found
	        throw new ResourceNotFoundException("User with given id is not found on Server !! : " + userId);
	        // Or, you can handle it in a different way, e.g., return a default user or log a message.
	    }
	    
	}


}
