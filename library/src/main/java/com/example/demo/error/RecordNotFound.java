package com.example.demo.error;

import java.time.LocalDate;

public class RecordNotFound extends RuntimeException {

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	private LocalDate date;
	private boolean success;
	public RecordNotFound() {
		super();
	}
	public RecordNotFound(String message) {
		super();
		this.message = message;
		this.date=LocalDate.now();
		this.success=false;
	}
	
}
