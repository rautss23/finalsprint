package com.creditcard.exception;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionhandler extends ResponseEntityExceptionHandler {
	private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(GlobalExceptionhandler.class);



	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(Exception ex) {
	LOGGER.error(ex.getMessage(), ex);
	ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	return responseEntity;
	}
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFound(Exception ex) {
	LOGGER.error(ex.getMessage(), ex);
	ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	return responseEntity;
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotFound(Exception ex) {
	LOGGER.error(ex.getMessage(), ex);
	ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	return responseEntity;
	}
}