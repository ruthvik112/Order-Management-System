package com.omsauth.api.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class controllerAdvice {
	 @ExceptionHandler(value = userNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(userNotFoundException ex, WebRequest request) {
	 return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
 }
	 @ExceptionHandler(value = NullPointerException.class)
	    public ResponseEntity<Object> handleRoleNotFoundException(NullPointerException ex, WebRequest request) {
		 return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	 }
	

}
