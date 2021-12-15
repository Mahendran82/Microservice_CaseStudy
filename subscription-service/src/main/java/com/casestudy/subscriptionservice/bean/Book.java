package com.casestudy.subscriptionservice.bean;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	private String id ;
    private String name;
	
    private String author;
	
    private int numcopiesAvailable ;
	
    private int totalCopies ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumcopiesAvailable() {
		return numcopiesAvailable;
	}

	public void setNumcopiesAvailable(int numcopiesAvailable) {
		this.numcopiesAvailable = numcopiesAvailable;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
    
    

}
