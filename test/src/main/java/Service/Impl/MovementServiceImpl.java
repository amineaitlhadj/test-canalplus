package Service.Impl;

import java.util.Collection;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canalplus.test.Model.Movement;

import DAO.MovementRepository;
import Service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {
	
	@Autowired
	private MovementRepository movementRepository;
	
	public MovementServiceImpl() {
		
	}
	
	/*@Autowired
	public MovementServiceImpl(MovementRepository movementR) {
		this.movementRepository = movementR;
	}*/
	
	

	@Override
	public Collection<Movement> getAllMovements() {
		return IteratorUtils.toList(movementRepository.findAll().iterator());
	}

	@Override
	public Movement saveMovement(Movement m) {
		Movement movement = new Movement();
		movement.setModification(m.getModification_type());
		movement.setModification_date(m.getModification_date());
		movement.setNew_value(m.getNew_value());
		movement.setOld_value(m.getOld_value());
		movement.setSubscriber(m.getSubscriberId());
		movement.setSubscription(m.getSubscriptions());
		this.movementRepository.save(movement);
		return movement;
	}

}
