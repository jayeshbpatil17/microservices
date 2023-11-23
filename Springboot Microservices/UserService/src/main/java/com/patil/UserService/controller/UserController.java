package com.patil.UserService.controller;

import com.patil.UserService.Entity.User;
import com.patil.UserService.repositories.UserRepository;
import com.patil.UserService.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl  userServiceImpl;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userServiceImpl.saveUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> listOfUsers = userServiceImpl.getAllUser();
        return ResponseEntity.ok().body(listOfUsers);
    }
}
