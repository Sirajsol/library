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
import com.example.demo.model.Patron;
import com.example.demo.service.BookService;
import com.example.demo.service.PatronService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/patrons")
public class PatronController {
private PatronService patronService;

public PatronController(PatronService patronService) {
	super();
	this.patronService=patronService; 
}

@GetMapping("")
public List<Patron>getAllPatrons(){
	return patronService.finadAllPatrons();
}
@GetMapping("/{id}")
public Patron Patron(@PathVariable long id){
	return patronService.findById(id).get();
}
@PostMapping("")
public Patron addPatron(@RequestBody Patron patron) {
	return patronService.save(patron);
	
}

@PutMapping("/{id}")
public String editBook(@RequestBody Patron patron,@PathVariable long id) {
	Patron p=patronService.findById(id).get();
	if(patron.getName()!=null)p.setName(patron.getName());
	if(patron.getAddress()!=null)p.setAddress(patron.getAddress());
	if(patron.getContacts()!=null)p.setContacts(patron.getContacts());
	
	patronService.save(p);
	return "patron edited";
	
}

@DeleteMapping("{id}")
public String deletePatron(@PathVariable long id) {
	return "";
}
}
