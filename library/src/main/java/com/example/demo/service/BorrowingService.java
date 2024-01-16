package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.error.NotReturned;
import com.example.demo.error.RecordNotFound;
import com.example.demo.model.Book;
import com.example.demo.model.Borrowing;
import com.example.demo.model.Patron;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.BorrowingRepo;
import com.example.demo.repo.PatronRepo;

@Service

public class BorrowingService {
	private BorrowingRepo borrowingRepo;
	private BookService bs;
	private PatronService ps;
	public BorrowingService(BorrowingRepo borrowingRepo,PatronService ps,BookService bs) {
		super();
		this.borrowingRepo=borrowingRepo;
		this.ps=ps;
		this.bs=bs;
	}

	public Borrowing save(Borrowing borrowing) {
	
			return borrowingRepo.save(borrowing);
		
	}
	public Borrowing save(Borrowing borrowing,long bid,long pid) {
		if(borrowingRepo.findnotreturned(bid, pid)!=null) 
		{throw new NotReturned("you must return the book first before trying to borrow it again!");}
		Patron p=ps.findById(pid).get();
		System.out.println("patron name "+p.getName());
		Book b=bs.findById(bid).get();
		borrowing.setPatron(p);
		borrowing.setBook(b);
		borrowing.setBorrowdate(LocalDate.now().toString());
		borrowing.setReturndate("non");
		return borrowingRepo.save(borrowing);
	
}
	public Borrowing findById(long id) {
		if(borrowingRepo.findById(id).isEmpty()) throw new RecordNotFound("no data for such id");
		return borrowingRepo.findById(id).get();
		
	}
	
	public Borrowing findnotReturned(long bid,long pid) {
//		if(borrowingRepo.findnotreturned(bid, pid).isPresent()) 
//		{throw new NotReturned("you must return the book first before trying to borrow it again!");}
		return borrowingRepo.findnotreturned(bid, pid);
	}
	public List<Borrowing>finadAllBorrowins(){
		return borrowingRepo.findAll();
	}
	public  Optional<Borrowing> findByPatronIdAndBookId(long bid,long pid) {
		return borrowingRepo.findByPatronIdAndBookId(bid,pid);
	}
	
	public String deleteBorrowing(long id) {
		borrowingRepo.deleteById(id);
		return "deleted";
	}
}
