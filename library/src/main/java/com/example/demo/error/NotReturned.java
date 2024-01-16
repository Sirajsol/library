package com.example.demo.error;

import java.time.LocalDate;

public class NotReturned extends RuntimeException{
private String message;
private LocalDate date;
private boolean success;
public NotReturned() {
	super();
}
public NotReturned(String message) {
	super();
	this.message=message;
	this.date=LocalDate.now();
	success=false;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
