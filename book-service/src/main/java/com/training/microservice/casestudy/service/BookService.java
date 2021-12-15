package com.training.microservice.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.training.microservice.casestudy.data.model.Book;
import com.training.microservice.casestudy.data.repository.BookRepo;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepo repo;
	
	public List<Book> listAll() {
		return repo.findAll();
	}
	
	public Book save(Book book) {		
		return repo.save(book);
	}
	
	public Book get(String bookid) {
		return repo.getBookByUsingId(bookid);
	}

}
