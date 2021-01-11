package DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canalplus.test.Model.Subscriber;

@Repository("SubscriberRepository")
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

		Optional<Subscriber> findById(Long id);
}
