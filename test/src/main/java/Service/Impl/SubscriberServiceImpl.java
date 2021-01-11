package Service.Impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.IteratorUtils;

import com.canalplus.test.Model.Movement;
import com.canalplus.test.Model.Subscriber;
import com.canalplus.test.Model.Subscription;


import DAO.SubscriberRepository;
import Service.MovementService;
import Service.SubscriberService;
import Service.SubscriptionService;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private MovementService movementService;
	
	
	public SubscriberServiceImpl() {
	}
	
	public SubscriberServiceImpl(SubscriberRepository subscriberR) {
		this.subscriberRepository = subscriberR;
	}

	@Override
	public Collection<Subscriber> getAllSuscribers() {
		return IteratorUtils.toList(subscriberRepository.findAll().iterator());
	}
	
	@Override
	public Subscriber getSubscriberById (Long id) {
		return subscriberRepository.getOne(id);
	}
	
	@Override
	public Subscriber editSubscriberAdress(Long id, String adress) {
		Subscriber subscriber = this.getSubscriberById(id);
		if (subscriber == null) {
			System.out.println("Utilisateur inexistant");
		}
		else {
			
			// Création du mouvement de modification
			Movement m = new Movement();
			m.setModification("Adresse");
			m.setModification_date(new Date());
			m.setNew_value(adress);
			m.setOld_value(subscriber.getAdresse());
			m.setSubscriber(subscriber.getId());
			
			Set<Long> subs = new HashSet<>();
			for (Subscription s : subscriber.getSubscriptions()) {
				subs.add(s.getId());
			}
			
			m.setSubscription(subs);
			movementService.saveMovement(m);
			
			//Modifiation de l'adresse de l'abonné
			subscriber.setAdresse(adress);
		}
		
		//Modification de l'adresse sur tous les contrats de l'abonné
		Set<Subscription> subscriptions = subscriber.getSubscriptions();
		for(Subscription a : subscriptions) {
			a.setAdresse(subscriber.getAdresse());
		}
		subscriber.setSubscriptions(subscriptions);
		this.subscriberRepository.save(subscriber);
		return subscriber;
	}

	@Override
	public Collection<Subscription> getSubscriptionInfos(Long id) {
		Subscriber subscriber = this.getSubscriberById(id);
		return subscriber.getSubscriptions();
	}

	@Override
	public Subscriber saveSubscriber(String nom, String prenom, String adresse) {
		Subscriber s = new Subscriber();
		s.setNom(nom);
		s.setPrenom(prenom);
		s.setAdresse(adresse);
		this.subscriberRepository.save(s);
		return s;
	}

	@Override
	public Subscriber subscribe(Long id, String adress) {
		Subscription s = subscriptionService.saveSubscription(adress);
		Subscriber sub = subscriberRepository.getOne(id);
		sub.getSubscriptions().add(s);
		subscriberRepository.save(sub);
		return sub;
	}

	@Override
	public Subscriber editSubscriberAdressAbroad(Long id, String adress) {
		Subscriber subscriber = this.getSubscriberById(id);
		if (subscriber == null) {
			System.out.println("Utilisateur inexistant");
		}
		else {
			
			// Création du mouvement de modification
			Movement m = new Movement();
			m.setModification("Adresse");
			m.setModification_date(new Date());
			m.setNew_value(adress);
			m.setOld_value(subscriber.getAdresse());
			m.setSubscriber(subscriber.getId());
			
			Set<Long> subs = new HashSet<>();
			for (Subscription s : subscriber.getSubscriptions()) {
				subs.add(s.getId());
			}
			
			m.setSubscription(subs);
			movementService.saveMovement(m);
			
			//Modifiation de l'adresse de l'abonné
			subscriber.setAdresse(adress);
		}
		
		//Modification de l'adresse sur le premier contrat de l'abonné
		Set<Subscription> subscriptions = subscriber.getSubscriptions();
		Subscription sub = subscriptions.stream().findFirst().get();
		sub.setAdresse(adress);
		subscriptions.add(sub);
		subscriber.setSubscriptions(subscriptions);
		this.subscriberRepository.save(subscriber);
		return subscriber;
	}

}
