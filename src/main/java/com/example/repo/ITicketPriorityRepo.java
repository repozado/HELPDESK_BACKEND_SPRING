package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TicketPriority;

public interface ITicketPriorityRepo extends JpaRepository<TicketPriority, Integer>{

}
