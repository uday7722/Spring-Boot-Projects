package com.spring.actor.exception;

public class ActorObjectNotFoundByIdException extends RuntimeException {
	private String message;
	
	public ActorObjectNotFoundByIdException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
}
