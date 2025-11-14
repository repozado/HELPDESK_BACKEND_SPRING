package com.example.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TicketStatus;

public interface ITicketStatusRepo extends JpaRepository<TicketStatus, Integer> {
    Optional<TicketStatus> findByNombre(String nombre);
}