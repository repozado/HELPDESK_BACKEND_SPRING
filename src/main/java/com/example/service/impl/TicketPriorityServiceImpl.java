package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.TicketPriority;
import com.example.repo.ITicketPriorityRepo;
import com.example.service.ITicketPriorityService;


@Service
public class TicketPriorityServiceImpl implements ITicketPriorityService{

	@Autowired
	private ITicketPriorityRepo repo;

	@Override
	public List<TicketPriority> getAll() {
		return repo.findAll();
	}

	@Override
	public Optional<TicketPriority> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public TicketPriority create(TicketPriority priority) {
		return repo.save(priority);
	}

	@Override
	public TicketPriority update(Integer id,TicketPriority priority) {
		if(repo.existsById(id)) {
			priority.setId_priority(id);
			return repo.save(priority);
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
	
}
