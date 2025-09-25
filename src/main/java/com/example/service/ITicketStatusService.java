package com.example.service;

import java.util.Optional;

import com.example.models.TicketStatus;

public interface ITicketStatusService {
  Optional<TicketStatus> findById(Integer id);
}