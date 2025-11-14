package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.TicketComment;
import com.example.repo.ITicketCommentRepo;
import com.example.service.ITicketCommentService;

@Service
@Transactional
public class TicketCommentServiceImpl implements ITicketCommentService {

	@Autowired
	private ITicketCommentRepo repo;
	
	@Transactional
	@Override
	public List<TicketComment> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Optional<TicketComment> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public TicketComment create(TicketComment ticketComment) {
		return repo.save(ticketComment);
	}

	@Transactional
	@Override
	public TicketComment update(Integer id, TicketComment ticketComment) {
		if (repo.existsById(id)) {
			ticketComment.setId(id);
			return repo.save(ticketComment);
		}
		return null;
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}
