package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.TicketPriority;



public interface ITicketPriorityService {
	List<TicketPriority> getAll();
	Optional<TicketPriority> findById(Integer id);
	TicketPriority create(TicketPriority priority);
	TicketPriority update(Integer id,TicketPriority priority);
	void delete(Integer id);
}
