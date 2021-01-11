package Service.Impl;

import java.util.Collection;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canalplus.test.Model.Subscription;

import DAO.SubscriptionRepository;
import Service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	public SubscriptionServiceImpl() {
		
	}
	
	/*@Autowired
	public SubscriptionServiceImpl(SubscriptionRepository subscriptionR) {
		this.subscriptionRepository = subscriptionR;
	}*/
	@Override
	public Subscription getSubscriptionById(Long id) {
		return this.subscriptionRepository.getOne(id);
	}

	@Override
	public Subscription saveSubscription(String adresse) {
		Subscription subscription = new Subscription();
		subscription.setAdresse(adresse);
		
		this.subscriptionRepository.save(subscription);
		
		return subscription;
	}

	@Override
	public Collection<Subscription> getAllSuscribers() {
		return IteratorUtils.toList(subscriptionRepository.findAll().iterator());
	}

}
