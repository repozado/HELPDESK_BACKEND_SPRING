package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.TicketComment;

public interface ITicketCommentRepo extends JpaRepository<TicketComment, Integer> {

}
