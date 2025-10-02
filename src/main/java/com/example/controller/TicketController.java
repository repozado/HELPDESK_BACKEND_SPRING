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

import com.example.models.Ticket;
import com.example.service.ITicketService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ticket")
public class TicketController {
	@Autowired
	private ITicketService service;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> getAllTicket(){
		List<Ticket> ticket = service.getAll();
		return new ResponseEntity<List<Ticket>>(ticket, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ticket>> getTicket(@PathVariable("id") Integer id){
		Optional<Ticket> ticket = service.findById(id);
		return new ResponseEntity<Optional<Ticket>>(ticket, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
		Ticket createticket = service.create(ticket);
		return new ResponseEntity<Ticket>(createticket, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") Integer id,@RequestBody Ticket ticket){
		Ticket updateticket = service.update(id,ticket);
		return new ResponseEntity<Ticket>(updateticket, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Ticket>deleteTicket(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<Ticket>(HttpStatus.OK);
	}
}
