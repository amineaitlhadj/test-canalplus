package com.canalplus.test.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.test.Model.Subscriber;
import com.canalplus.test.Model.Subscription;

import Service.SubscriberService;


@RequestMapping("/subscriber/*")
@RestController
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping(value = "/subscribers")
	public ResponseEntity<Collection<Subscriber>> getAllSubscribers() {
		Collection<Subscriber> subscribers = subscriberService.getAllSuscribers();
		return new ResponseEntity<Collection<Subscriber>>(subscribers, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<Subscriber> getSubscriberById(@RequestParam(value = "id", required = true) Long id) {
		Subscriber subscriber = subscriberService.getSubscriberById(id);
		return new ResponseEntity<Subscriber>(subscriber, HttpStatus.FOUND);
	}
	
	@PostMapping(value = "/subscribers")
	@Transactional
	public ResponseEntity<Subscriber> saveSubscriber(@RequestBody Subscriber s) {
		Subscriber sub = subscriberService.saveSubscriber(s.getNom(), s.getPrenom(), s.getAdresse());
		return new ResponseEntity<Subscriber>(sub, HttpStatus.CREATED);
	}
	
	@PutMapping (value = "/subscribers")
	public ResponseEntity<Subscriber> editSubscriberAdress(@RequestBody Subscriber s) {
		Subscriber sub = subscriberService.editSubscriberAdress(s.getId(), s.getAdresse());
		return new ResponseEntity<Subscriber>(sub, HttpStatus.OK);
	}
	
	@PutMapping (value = "/subscribers/abroad")
	public ResponseEntity<Subscriber> editSubscriberAbroadAdress (@RequestBody Subscriber s) {
		Subscriber sub = subscriberService.editSubscriberAdressAbroad(s.getId(), s.getAdresse());
		return new ResponseEntity<Subscriber>(sub, HttpStatus.OK);
	}
	
	@PostMapping(value = "subscribers/subscribe")
	public ResponseEntity<Subscriber> subscribe(@RequestParam(value = "id", required = true) Long id, @RequestParam (value ="adress", required = true) String adress) {
		Subscriber sub = subscriberService.subscribe(id, adress);
		return new ResponseEntity<Subscriber>(sub, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/subscriptions")
	public ResponseEntity<Collection<Subscription>> getSubscriberInfos(@RequestParam(value = "id", required = true) Long id) {
		Collection<Subscription> subscriptions = subscriberService.getSubscriptionInfos(id);
		return new ResponseEntity<Collection<Subscription>>(subscriptions, HttpStatus.FOUND);
	}
	

}
