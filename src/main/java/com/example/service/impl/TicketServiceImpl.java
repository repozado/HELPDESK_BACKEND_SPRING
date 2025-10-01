package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Ticket;
import com.example.repo.ITicketRepo;
import com.example.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketRepo repo;
	
	@Override
	public List<Ticket> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Ticket> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public Ticket create(Ticket ticket) {
		return repo.save(ticket);
	}

	@Override
	public Ticket update(Integer id, Ticket ticket) {
		if(repo.existsById(id)){
			ticket.setId_ticket(id);
			return repo.save(ticket);
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		if(repo.existsById(id)){
			repo.deleteById(id);
		}
	}

}
