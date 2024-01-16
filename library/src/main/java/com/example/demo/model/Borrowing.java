package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
//@Table( 
//uniqueConstraints = { @UniqueConstraint(columnNames = 
//                                        { "book_id", "patron_id" }) })
public class Borrowing {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private long id;
private String type;
public String getType() {
	return type;
}

public Borrowing() {
	super();
	// TODO Auto-generated constructor stub
}

public Borrowing(String borrowdate, String returndate) {
	super();
	this.borrowdate = borrowdate;
	this.returndate = returndate;
}

public void setType(String type) {
	this.type = type;
}
public long getId() {
	return id;
}
public String getBorrowdate() {
	return borrowdate;
}

public String getReturndate() {
	return returndate;
}

public void setReturndate(String returndate) {
	this.returndate = returndate;
}

//public void setId(long id) {
//	this.id = id;
//}

public void setBorrowdate(String date) {
	this.borrowdate = date;
}

public Patron getPatron() {
	return patron;
}

public void setPatron(Patron patron) {
	this.patron = patron;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

private String borrowdate;
private String returndate;

@ManyToOne
private Patron patron;

@ManyToOne
private Book book;

}
