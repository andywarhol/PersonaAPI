package com.aurrea.persona.service;


import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExcHandler {

	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<ErrorDetails> psqlExc(PSQLException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Esta persona ya existe, guarda otro nombre", 800 );
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> nullPoint(NullPointerException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Persona desconocida, intente escribir el nombre completo", 1000);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ErrorDetails> illegalStateExc(IllegalStateException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Lista Vacia, No hay personas en base de datos", 1500);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
