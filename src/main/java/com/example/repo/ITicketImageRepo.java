package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TicketImage;

public interface ITicketImageRepo extends JpaRepository<TicketImage, Integer> {

}
