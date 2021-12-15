package com.training.microservice.casestudy.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.microservice.casestudy.data.model.Book;

public interface BookRepo extends JpaRepository<Book, String> {
	

	@Query(value ="select * from book where BOOK_ID = :bookId",nativeQuery = true)
	public Book getBookByUsingId(String bookId);
}

