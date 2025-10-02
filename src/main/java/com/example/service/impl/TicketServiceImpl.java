package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Ticket;
import com.example.repo.ITicketRepo;
import com.example.service.ITicketService;

@Service
@Transactional
public class TicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketRepo repo;
	
	@Transactional
	@Override
	public List<Ticket> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Optional<Ticket> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public Ticket create(Ticket ticket) {
		return repo.save(ticket);
	}

	@Transactional
	@Override
	public Ticket update(Integer id, Ticket ticket) {
		if(repo.existsById(id)){
			ticket.setId_ticket(id);
			return repo.save(ticket);
		}
		return null;
	}
	@Transactional
	@Override
	public void delete(Integer id) {
		if(repo.existsById(id)){
			repo.deleteById(id);
		}
	}

}
