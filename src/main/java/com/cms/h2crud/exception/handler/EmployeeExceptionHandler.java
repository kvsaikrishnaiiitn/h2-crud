package com.cms.h2crud.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cms.h2crud.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException enfe) {
		return new ResponseEntity<>(enfe, HttpStatus.NOT_FOUND);
	}

}
