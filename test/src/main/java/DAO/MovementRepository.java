package DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canalplus.test.Model.Movement;

@Repository("MovementRepository")
public interface MovementRepository extends JpaRepository<Movement, Long>{
	
	Optional <Movement> findById (Long id);

}
