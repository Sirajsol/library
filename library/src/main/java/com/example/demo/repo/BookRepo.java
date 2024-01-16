package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Book;

public interface BookRepo  extends JpaRepository<Book, Long>{
	
	public Book findByTitle(String name);
}
