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

import com.example.models.TicketImage;
import com.example.service.ITicketImageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ticket-image")
public class TicketImageController {
	@Autowired
	private ITicketImageService service;
	
	@GetMapping
	public ResponseEntity<List<TicketImage>> getAllTicketImage() {
		List<TicketImage> images = service.getAll();
		return new ResponseEntity<List<TicketImage>>(images, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TicketImage>> getTicketImage(@PathVariable("id") Integer id) {
		Optional<TicketImage> image = service.findById(id);
		return new ResponseEntity<Optional<TicketImage>>(image, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TicketImage> createTicketImage(@RequestBody TicketImage ticketImage) {
		TicketImage created = service.create(ticketImage);
		return new ResponseEntity<TicketImage>(created, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TicketImage> updateTicketImage(@PathVariable("id") Integer id, @RequestBody TicketImage ticketImage) {
		TicketImage updated = service.update(id, ticketImage);
		return new ResponseEntity<TicketImage>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTicketImage(@PathVariable("id") Integer id) {
	    try {
	        service.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
