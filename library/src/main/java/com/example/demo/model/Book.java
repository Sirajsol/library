package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
//@Getter
//@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Book {
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPubYear() {
		return pubYear;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public Set<Borrowing> getBorrowings() {
		return borrowings;
	}
	public void setBorrowings(Set<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String author;
	private String title;
	private int pubYear;
	private boolean available;
//	@Column(unique = true)
	private String isbn;
	
	public Book(String author, String title, int pubYear, boolean available, String isbn) {
		super();
		
		this.author = author;
		this.title = title;
		this.pubYear = pubYear;
		this.available = available;
		this.isbn = isbn;
		this.borrowings = null;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private Set<Borrowing>borrowings=new HashSet<Borrowing>();
	

}
