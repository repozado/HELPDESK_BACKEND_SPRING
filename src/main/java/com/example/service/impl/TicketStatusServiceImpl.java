package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.TicketStatus;
import com.example.repo.ITicketStatusRepo;
import com.example.service.ITicketStatusService;

@Service
public class TicketStatusServiceImpl implements ITicketStatusService {

	@Autowired
	private ITicketStatusRepo repo;
	
	@Override
	public List<TicketStatus> getAll() {
		return repo.findAll();
	}
	
	@Override
	public Optional<TicketStatus> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public TicketStatus create(TicketStatus status) {
		return repo.save(status);
	}
	@Override
	public TicketStatus update(Integer id,TicketStatus status) {
		if(repo.existsById(id)){
			status.setId_status(id);
			return repo.save(status);
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
