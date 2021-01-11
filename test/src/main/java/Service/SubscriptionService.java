package Service;

import java.util.Collection;
import com.canalplus.test.Model.Subscription;

public interface SubscriptionService {
	
	Collection<Subscription> getAllSuscribers();
	
	Subscription getSubscriptionById(Long id);
	
	Subscription saveSubscription (String adresse);
}
