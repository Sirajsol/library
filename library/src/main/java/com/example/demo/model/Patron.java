package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.Borrowing;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patron {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String name;
	private String address;
	private String contacts;
	@JsonIgnore
	@OneToMany(mappedBy = "patron")
	private Set<Borrowing>borrowings=new HashSet<Borrowing>();
}
