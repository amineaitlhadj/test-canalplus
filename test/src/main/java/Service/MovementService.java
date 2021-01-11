package Service;

import java.util.Collection;

import com.canalplus.test.Model.Movement;

public interface MovementService {

	Collection<Movement> getAllMovements();
	
	Movement saveMovement(Movement m);
}
