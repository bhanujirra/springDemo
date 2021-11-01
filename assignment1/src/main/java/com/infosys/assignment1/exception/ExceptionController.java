package com.infosys.assignment1.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.assignment1.dto.ErrorMessage;

@Component
@PropertySource("classpath:messages.properties")
@RestControllerAdvice
public class ExceptionController {
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex) {
		ErrorMessage error = new ErrorMessage();
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AssignmentException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(AssignmentException e) {
		ErrorMessage error = new ErrorMessage();
		error.setMessage(environment.getProperty(e.getMessage()));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
