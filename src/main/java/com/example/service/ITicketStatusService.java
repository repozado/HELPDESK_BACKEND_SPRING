package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.TicketStatus;

public interface ITicketStatusService {
	List<TicketStatus> getAll();
	Optional<TicketStatus> findById(Integer id);
	TicketStatus create(TicketStatus status);
	TicketStatus update(TicketStatus status);
	void delete(Integer id);
}