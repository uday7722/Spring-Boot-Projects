package com.spring.actor.exception;

public class ActorsNotFoundException extends RuntimeException {
	
	private String message;
	
	public ActorsNotFoundException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}

}
