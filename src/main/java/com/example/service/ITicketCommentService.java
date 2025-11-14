package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.TicketComment;

public interface ITicketCommentService {
	List<TicketComment> getAll();
	Optional<TicketComment> findById(Integer id);
	TicketComment create(TicketComment ticketComment);
	TicketComment update(Integer id, TicketComment ticketComment);
	void delete(Integer id);
}
