package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Controlleradv {
	
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<?> handler(RecordNotFound rnf){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rnf.getMessage());
}
	
	@ExceptionHandler(NotReturned.class)
	public ResponseEntity<?> handler(NotReturned rnf){
		eErrorBody eb=new eErrorBody(rnf.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eb);
}
	
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> handler(java.sql.SQLIntegrityConstraintViolationException ex){
		eErrorBody eb=new eErrorBody(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eb);
}
}
