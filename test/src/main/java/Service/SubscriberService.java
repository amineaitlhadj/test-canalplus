package Service;

import java.util.Collection;

import com.canalplus.test.Model.Subscriber;
import com.canalplus.test.Model.Subscription;

public interface SubscriberService {
	
	Collection<Subscriber> getAllSuscribers();
	
	Subscriber saveSubscriber(String nom, String prenom, String adresse);
	
	Subscriber getSubscriberById (Long id);
	
	Subscriber editSubscriberAdress (Long id, String adress);
	
	Subscriber editSubscriberAdressAbroad (Long id, String adress);
	
	Subscriber subscribe(Long id, String adress);
	
	Collection<Subscription> getSubscriptionInfos (Long id);

}
