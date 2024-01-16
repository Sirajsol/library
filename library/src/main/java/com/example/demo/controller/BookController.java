package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/books")
public class BookController {
private BookService bookService;

public BookController(BookService bookService) {
	super();
	this.bookService=bookService; 
}

@GetMapping("")
public List<Book>getAllBooks(){
	return bookService.finadAllBooks();
}
@GetMapping("/{id}")
public Book GetBook(@PathVariable long id){
	return bookService.findById(id).get();
//	return new Book();
}
@PostMapping("")
public Book addBook(@RequestBody Book book) {
	return bookService.save(book);
	
}
@PutMapping("/{id}")
public String editBook(@RequestBody Book book,@PathVariable long id) {
	Book b=bookService.findById(id).get();
	if(book.getAuthor()!=null)b.setAuthor(book.getAuthor());
	if(book.getIsbn()!=null)b.setIsbn(book.getIsbn());
	if(book.getTitle()!=null)b.setTitle(book.getTitle());
	if(book.getPubYear()!=0)b.setPubYear(book.getPubYear());
	
	bookService.save(b);
	return "book edited";
	
}

@DeleteMapping("/{id}")
public String editBook(@PathVariable long id) {
	
	return bookService.delete(id);
}

}
