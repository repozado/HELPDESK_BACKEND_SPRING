package com.example.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.models.TicketStatus;

@Service
public interface ITicketStatusService {
  Optional<TicketStatus> findById(Integer id);
}
