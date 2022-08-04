package com.ticket.my.book.service.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ticket.my.book.custom.exception.UserNotFoundException;


@ControllerAdvice
public class HandleGlobalException {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Error> handleUserNameNotFoundException(UserNotFoundException userNotFound) {
		Error error = Error.builder().description(userNotFound.getMessage()).statusCode(HttpStatus.NOT_FOUND.value()).build();
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Error> handleBadCredential(BadCredentialsException badCredential) {
		Error error = Error.builder().description("Invalid Password").statusCode(HttpStatus.BAD_REQUEST.value()).build();
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

}
