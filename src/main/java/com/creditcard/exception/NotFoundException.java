package com.creditcard.exception;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException  {
	public NotFoundException(String message) {     
		super(message);
	}
public NotFoundException() {
	
}
}
