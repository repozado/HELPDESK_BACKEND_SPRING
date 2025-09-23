package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.TicketStatus;
import com.example.service.ITicketStatusService;

@RestController
@RequestMapping("/ticketStatus")
public class TicketStatusController {

	@Autowired
	private ITicketStatusService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TicketStatus>> getTicket(@PathVariable("id") Integer id){
		Optional<TicketStatus> tick = service.findById(id);
		
		return new ResponseEntity<Optional<TicketStatus>>(tick, HttpStatus.OK);
	}
}
