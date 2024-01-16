package com.example.demo.error;

import java.time.LocalDate;

public class eErrorBody {
private String message;
private LocalDate date;
private boolean success;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public eErrorBody() {
	super();
	// TODO Auto-generated constructor stub
}
public eErrorBody(String message) {
	super();
	this.message = message;
	this.date=LocalDate.now();
	this.success=false;
}

}
