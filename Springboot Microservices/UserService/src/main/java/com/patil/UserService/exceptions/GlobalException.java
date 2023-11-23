package com.patil.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.patil.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException{
	
	//global exception handler
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
	        String message = ex.getMessage();
	        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	 }
}
