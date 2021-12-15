package com.casestudy.subscriptionservice.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.casestudy.subscriptionservice.bean.Book;
import com.casestudy.subscriptionservice.bean.Subscription;
import com.casestudy.subscriptionservice.service.SubscriptionService;

@RestController
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subService;
	
	
	@GetMapping("/subscription-service/subscription")
	public List<Subscription> getSubscription(){
		return subService.getAll();
	}
	
	
	@PostMapping(value ="/subscription-service/subscription",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subs) throws Exception{		
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url="http://localhost:8090/book-service/books/{bookId}";
		HashMap<String, String> urlvalues= new HashMap<>();
		urlvalues.put("bookId", subs.getBookId());
		
		ResponseEntity<Book> response = restTemplate.getForEntity(url,Book.class,urlvalues);
		Book bookResponse= response.getBody();
		
		Subscription sub=null;
		if(bookResponse.getNumcopiesAvailable()!=0) {
			sub = subService.addSubscription(subs);			
		}
		if (sub == null) {
			throw new Exception();
		} else {
		        return new ResponseEntity<Subscription>(sub, HttpStatus.CREATED);
		}
		
		   
	}
}
