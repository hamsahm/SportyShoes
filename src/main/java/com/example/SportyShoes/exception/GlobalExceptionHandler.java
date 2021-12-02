package com.example.SportyShoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handle(UserNotFoundException userNotFoundException, WebRequest webRequest) {
		return new ResponseEntity<String>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidDateFormatException.class)
	public ResponseEntity<String> handle(InvalidDateFormatException invalidDateFormatException, WebRequest webRequest) {
		return new ResponseEntity<String>(invalidDateFormatException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
