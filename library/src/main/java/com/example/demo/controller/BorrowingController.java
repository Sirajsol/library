package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;
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
import com.example.demo.model.Borrowing;
import com.example.demo.model.Patron;
import com.example.demo.service.BookService;
import com.example.demo.service.BorrowingService;
import com.example.demo.service.PatronService;

import jakarta.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
//@RequestMapping("api/borrow")
public class BorrowingController {
private BorrowingService borrowingService;
private BookService bookService;
private PatronService patronService;

public BorrowingController(BorrowingService borrowingService , PatronService patronService,BookService bookService) {
	super();
	this.borrowingService=borrowingService; 
	this.bookService=bookService; 
	this.patronService=patronService; 
}

@GetMapping("api/borrow")
public List<Borrowing>getAllBorrwings(){
	return borrowingService.finadAllBorrowins();
}

@PostMapping("api/borrow/{bid}/patron/{pid}")
public String addBorrowing(@PathVariable long pid,@PathVariable long bid) {
	Borrowing b=new Borrowing();
//	 LocalDate t=LocalDate.now();
//	b=borrowingService.findnotReturned(bid, pid);
//	if(b!=null) {
//		return "not return book yet";}
//	else {
//		b=new Borrowing();
//
//	
//	Date d=new Date();
//	//d.getDate()
//	b.setBorrowdate(t.toString());
//	b.setReturndate("non");
//	b.setType("borrow");
//	Book bk=bookService.findById(bid) ;
//	Patron p=patronService.findById(pid);
//	System.out.println("pname: "+p.getName());
//	System.out.println("b title"+bk.getTitle());
//	bk.setAvailable(false);
//	bk=bookService.save(bk);
//	b.setBook(bk);
//	b.setPatron(p);
	 borrowingService.save(b,bid,pid);
	 return "new borrow added";
	}
	

@GetMapping("/{id}")
public Borrowing getBorrowing(@PathVariable long id){
	return borrowingService.findById(id);
}
@PutMapping("api/return/{bid}/patron/{pid}")
public Borrowing returnBorrowing(@PathVariable long pid,@PathVariable long bid) {
	Borrowing b=borrowingService.findnotReturned(bid, pid);
	
	 LocalDate t=LocalDate.now();
	System.out.println("pname: "+t);
	//d.getDate()
	b.setReturndate(t.toString());
	b.setType("return");
	Book bk=bookService.findById(bid).get() ;
	Patron p=patronService.findById(pid).get();
	System.out.println("pname: "+p.getName());
	System.out.println("b title"+bk.getTitle());
	bk.setAvailable(true);
	bk=bookService.save(bk);
	
	b.setBook(bk);
	b.setPatron(p);
//	bk.setAvailable(true);
	return borrowingService.save(b);
	
}
//@PostMapping("/save")
//public Borrowing addBorrowing(@RequestBody Borrowing br) {
//	
//	return borrowingService.save(br);
//	
//}

@DeleteMapping("/{id}")
public void deleteBook(@PathVariable long id) {
	borrowingService.deleteBorrowing(id);
}

}
