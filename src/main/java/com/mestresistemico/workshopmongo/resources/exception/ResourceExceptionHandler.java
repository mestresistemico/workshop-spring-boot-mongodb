package com.mestresistemico.workshopmongo.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mestresistemico.workshopmongo.services.exception.ObjectNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setError("Resource not found"); 
		err.setPath(request.getRequestURI()); 
		err.setStatus(HttpStatus.NOT_FOUND.value()); 
		err.setMessage(e.getMessage()); 
		err.setTimestamp(Instant.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}

}
