package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.TicketImage;

public interface ITicketImageService {
	List<TicketImage> getAll();
	Optional<TicketImage> findById(Integer id);
	TicketImage create(TicketImage ticketImage);
	TicketImage update(Integer id, TicketImage ticketImage);
	void delete(Integer id);
}
