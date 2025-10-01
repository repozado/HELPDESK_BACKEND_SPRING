package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.Ticket;

public interface ITicketService {
	List<Ticket> getAll();
	Optional<Ticket> findById(Integer id);
	Ticket create(Ticket ticket);
	Ticket update(Integer id, Ticket ticket);
	void delete(Integer id);
}
