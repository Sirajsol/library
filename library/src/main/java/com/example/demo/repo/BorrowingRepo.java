package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Borrowing;
import com.example.demo.model.Patron;

public interface BorrowingRepo  extends JpaRepository<Borrowing, Long>{
	
	
	@Query(value ="SELECT * from  borrowing where borrowing.book_id=?1 and borrowing.patron_id=?2"  ,nativeQuery=true)
	public Optional<Borrowing> findByPatronIdAndBookId(long bookId,long patronId);
	
	
	@Query(value ="SELECT * from  borrowing where borrowing.book_id=?1 and borrowing.patron_id=?2 and returndate='non'"  ,nativeQuery=true)
	public Borrowing findnotreturned(long bookId,long patronId);
	
	
	@Modifying
	@Transactional
	@Query(value ="Delete from  borrowing where  borrowing.patron_id=?1"  ,nativeQuery=true)
	public void deleteByPatronId(long patronId);
	
	
	@Modifying
	@Transactional
	@Query(value ="DELETE from  borrowing where borrowing.book_id=?1"  ,nativeQuery=true)
	public void deleteByBookId(long bookId);
}
