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
import com.example.demo.model.Patron;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.BorrowingRepo;
import com.example.demo.repo.PatronRepo;

import jakarta.transaction.Transactional;

@Service

public class PatronService {
	private PatronRepo patronRepo;
	private BorrowingRepo br;
	
	public PatronService(PatronRepo patronRepo,BorrowingRepo br) {
		super();
		this.patronRepo=patronRepo;
		this.br=br;
	}
	@CacheEvict(value = {"onePatron","allPatrons"}, key = "#root.methodName" ,allEntries = true)

	public Patron save(Patron patron) {
		return patronRepo.save(patron);
	}
	
//	@Cacheable(value="onePatron",key = "#root.methodName")
	public Optional<Patron> findById(long id) {
		if(patronRepo.findById(id).isEmpty()) {throw new NotReturned("no patron found for this id");}
		return patronRepo.findById(id);
	}
	@Cacheable(value="allPatrons",key = "#root.methodName")
	public List<Patron>finadAllPatrons(){
		return patronRepo.findAll();
	}
	
	@CacheEvict(value = {"onePatron","allPatrons"}, key = "#root.methodName" ,allEntries = true)

	@Transactional
	public String delete(long id)  {
		br.deleteByPatronId(id);
	
		 patronRepo.deleteById(id);
		 return "patron deleted successfully";
	}
}
