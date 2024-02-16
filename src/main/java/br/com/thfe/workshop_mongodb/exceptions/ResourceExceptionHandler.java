package br.com.thfe.workshop_mongodb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.thfe.workshop_mongodb.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>notFoundException(ObjectNotFoundException e, HttpServletRequest http){
		String error = "Id não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError mensageError = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(), http.getRequestURI(),error);
		return ResponseEntity.status(status).body(mensageError);
	}
}
