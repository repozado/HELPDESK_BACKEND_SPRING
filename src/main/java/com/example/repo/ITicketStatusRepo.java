package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TicketStatus;

public interface ITicketStatusRepo extends JpaRepository<TicketStatus, Integer>{

	
}
