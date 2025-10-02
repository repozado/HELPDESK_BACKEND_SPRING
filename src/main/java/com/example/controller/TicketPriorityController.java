package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.TicketPriority;
import com.example.models.TicketStatus;
import com.example.service.ITicketPriorityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ticketpriority")
public class TicketPriorityController {
	@Autowired
	private ITicketPriorityService service;
	
	
	@GetMapping
	public ResponseEntity<List<TicketPriority>> getAllPriorities(){
		List<TicketPriority> priorities= service.getAll();
		return new ResponseEntity<List<TicketPriority>>(priorities, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TicketPriority>> getPriority(@PathVariable("id") Integer id){
		Optional<TicketPriority> priority = service.findById(id);
		return new ResponseEntity<Optional<TicketPriority>>(priority, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TicketPriority> createPriority(@RequestBody TicketPriority priority){
		TicketPriority createpriority = service.create(priority);
		return new ResponseEntity<TicketPriority>(createpriority, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TicketPriority> updatePriority(@PathVariable("id")Integer id,@RequestBody TicketPriority priority){
		TicketPriority updatpriority = service.update(id,priority);
		return new ResponseEntity<TicketPriority>(updatpriority, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TicketPriority>deletePriority(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<TicketPriority>(HttpStatus.NO_CONTENT);
	}
}
