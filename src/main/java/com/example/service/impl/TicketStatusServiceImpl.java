package com.example.service.impl;

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
	public Optional<TicketStatus> findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
