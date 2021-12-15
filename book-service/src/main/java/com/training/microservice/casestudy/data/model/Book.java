package com.training.microservice.casestudy.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	
	@Id
	@Column(name="BOOK_ID")
	private String bookid;
	
	public String getBookId() {
		return bookid;
	}
	
	public void setBookId(String bookid) {
		
		this.bookid=bookid;
	}
	
	@Column(name="BOOK_NAME")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
