package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.models.TicketStatus;
import com.example.service.ITicketStatusService;

@RestController
@RequestMapping("/api/ticketstatus")
public class TicketStatusController {

	@Autowired
	private ITicketStatusService service;
	
	@GetMapping
	public ResponseEntity<List<TicketStatus>> getAllStatus(){
		List<TicketStatus> statuses = service.getAll();
		return new ResponseEntity<List<TicketStatus>>(statuses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TicketStatus>> getStatus(@PathVariable("id") Integer id){
		Optional<TicketStatus> status = service.findById(id);
		return new ResponseEntity<Optional<TicketStatus>>(status, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TicketStatus> createStatus(@RequestBody TicketStatus status){
		TicketStatus createstatus = service.create(status);
		return new ResponseEntity<TicketStatus>(createstatus, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TicketStatus> updateStatus(@PathVariable("id") Integer id,@RequestBody TicketStatus status){
		TicketStatus updatestatus = service.update(id,status);
		return new ResponseEntity<TicketStatus>(updatestatus, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TicketStatus>deleteStatus(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<TicketStatus>(HttpStatus.OK);
	}
}
