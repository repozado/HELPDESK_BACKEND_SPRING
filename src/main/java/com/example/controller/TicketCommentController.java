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

import com.example.models.TicketComment;
import com.example.service.ITicketCommentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ticket-comment")
public class TicketCommentController {
	@Autowired
	private ITicketCommentService service;
	
	@GetMapping
	public ResponseEntity<List<TicketComment>> getAllTicketComment() {
		List<TicketComment> comments = service.getAll();
		return new ResponseEntity<List<TicketComment>>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TicketComment>> getTicketComment(@PathVariable("id") Integer id) {
		Optional<TicketComment> comment = service.findById(id);
		return new ResponseEntity<Optional<TicketComment>>(comment, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TicketComment> createTicketComment(@RequestBody TicketComment ticketComment) {
		TicketComment created = service.create(ticketComment);
		return new ResponseEntity<TicketComment>(created, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TicketComment> updateTicketComment(@PathVariable("id") Integer id, @RequestBody TicketComment ticketComment) {
		TicketComment updated = service.update(id, ticketComment);
		return new ResponseEntity<TicketComment>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTicketComment(@PathVariable("id") Integer id) {
	    try {
	        service.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
