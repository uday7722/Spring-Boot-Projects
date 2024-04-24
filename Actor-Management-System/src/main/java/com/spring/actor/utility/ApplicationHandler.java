package com.spring.actor.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.actor.exception.ActorObjectNotFoundByIdException;
import com.spring.actor.exception.ActorsNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ActorObjectNotFoundByIdException actorObjectNotFoundException){
		
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(actorObjectNotFoundException.getMessage());
		errorStructure.setData("Actor Object is not present in the database and operation is failed !!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorsNotFoundException(ActorsNotFoundException actorsNotFoundException){
		
		ErrorStructure<String> errorStructure=new ErrorStructure<String>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(actorsNotFoundException.getMessage());
		errorStructure.setData("Actors not present in the database and operation failed !!");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
	}
	
}
