package com.qa.SpringGoose.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SpringGoose.domain.Goose;
import com.qa.SpringGoose.service.ServiceInterface;

@RestController
@RequestMapping("/Goose")
public class GooseController {

	private ServiceInterface<Goose> service;

	public GooseController(ServiceInterface service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Goose> createCadie(@RequestBody Goose goose) {
		return new ResponseEntity<Goose>(this.service.create(goose), HttpStatus.CREATED);
	}

	@PostMapping("/create")
	public ResponseEntity<Goose> createGoose(@RequestBody Goose goose) {
		return new ResponseEntity<Goose>(this.service.create(goose), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Goose>> readAllGoose() {
		return new ResponseEntity<List<Goose>>(this.service.readAll(), HttpStatus.FOUND);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Goose> readByIdGoose(@PathVariable Long id) {
		return new ResponseEntity<Goose>(this.service.readById(id), HttpStatus.FOUND);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Goose> updateGoose(@PathVariable Long id, @RequestBody Goose goose) {
		return new ResponseEntity<Goose>(this.service.update(id, goose), HttpStatus.ACCEPTED);

	}

	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteGoose(@PathVariable Long id) {
		boolean deleted = this.service.delete(id);

		return (deleted) ? new ResponseEntity<Boolean>(deleted, HttpStatus.OK)
				: new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_FOUND);
	}

}
