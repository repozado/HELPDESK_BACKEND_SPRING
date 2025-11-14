package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.TicketImage;
import com.example.repo.ITicketImageRepo;
import com.example.service.ITicketImageService;

@Service
@Transactional
public class TicketImageServiceImpl implements ITicketImageService {

	@Autowired
	private ITicketImageRepo repo;
	
	@Transactional
	@Override
	public List<TicketImage> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Optional<TicketImage> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public TicketImage create(TicketImage ticketImage) {
		return repo.save(ticketImage);
	}

	@Transactional
	@Override
	public TicketImage update(Integer id, TicketImage ticketImage) {
		if (repo.existsById(id)) {
			ticketImage.setId(id);
			return repo.save(ticketImage);
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
