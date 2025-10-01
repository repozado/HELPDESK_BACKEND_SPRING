package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Ticket;

public interface ITicketRepo extends JpaRepository<Ticket, Integer> {

}
