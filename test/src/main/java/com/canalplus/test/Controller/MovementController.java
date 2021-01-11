package com.canalplus.test.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canalplus.test.Model.Movement;

import Service.MovementService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 360)
@RestController
@RequestMapping("/movement/*")
public class MovementController {

	@Autowired
	MovementService movementService;
	
	@GetMapping(value = "/movements")
	public ResponseEntity<Collection<Movement>> getAllMovements() {
		Collection<Movement> movements = movementService.getAllMovements();
		return new ResponseEntity<Collection<Movement>>(movements, HttpStatus.FOUND);
	}
}
