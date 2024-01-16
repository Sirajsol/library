package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Patron;

public interface PatronRepo  extends JpaRepository<Patron, Long>{
	
	public Patron findByName(String name);
}
