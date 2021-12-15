package com.casestudy.subscriptionservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.subscriptionservice.Repositary.SubscriptionRepo;
import com.casestudy.subscriptionservice.bean.Subscription;

@Service
@Transactional
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepo repo;

	
	public Subscription addSubscription(Subscription subs) {
		return repo.save(subs);
	}
	
	public List<Subscription> getAll() {
		return repo.findAll();
	}    

	
}
