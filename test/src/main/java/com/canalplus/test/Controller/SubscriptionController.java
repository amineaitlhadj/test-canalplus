package com.canalplus.test.Controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canalplus.test.Model.Subscription;
import Service.SubscriptionService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 360)
@RestController
@RequestMapping("/subscription/*")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping(value = "/subscriptions")
	public ResponseEntity<Collection<Subscription>> getAllSubscriptions() {
		Collection<Subscription> subscribers = subscriptionService.getAllSuscribers();
		return new ResponseEntity<Collection<Subscription>>(subscribers, HttpStatus.FOUND);
	}
	
	@PostMapping(value = "/subscriptions")
	@Transactional
	public ResponseEntity<Subscription> saveSubscriber(@RequestBody Subscription s) {
		Subscription sub = subscriptionService.saveSubscription(s.getAdresse());
		return new ResponseEntity<Subscription>(sub, HttpStatus.CREATED);
	}

}
