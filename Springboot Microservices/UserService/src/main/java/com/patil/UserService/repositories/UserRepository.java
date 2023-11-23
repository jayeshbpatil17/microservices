package com.patil.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patil.UserService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	//IF you want to write the custome query 
	//write method here
	
}
