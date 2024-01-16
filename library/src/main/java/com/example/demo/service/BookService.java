package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.error.NotReturned;
import com.example.demo.model.Book;
import com.example.demo.model.Borrowing;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.BorrowingRepo;

import jakarta.transaction.Transactional;

@Service

public class BookService {
	private BookRepo bookRepo;
	private BorrowingRepo br;
	public BookService(BookRepo bookRepo,BorrowingRepo br) {
		super();
		this.bookRepo=bookRepo;
		this.br=br;
	}
@CacheEvict(value = {"allbooks"}, key = "#root.methodName" ,allEntries = true)
	public Book save(Book book) {
		return bookRepo.save(book);
	}
//	@Cacheable(value="onebook",key = "#root.methodName")
	public Optional<Book> findById(long id) {
		if(bookRepo.findById(id).isEmpty()) {throw new NotReturned("no book found for this id");}
		return bookRepo.findById(id);
	}
	@Cacheable(value="allbooks",key = "#root.methodName")
	public List<Book>finadAllBooks(){
		return bookRepo.findAll();
	}
	@Transactional
	@CacheEvict(value = {"onebook","allbooks"}, key = "#root.methodName" ,allEntries = true)
	public String delete(long id)  {
		br.deleteByBookId(id);
	
		 bookRepo.deleteById(id);
		 return "book deleted successfully";
	}
}
