package com.example.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TicketComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "ticket_id", nullable = false)
	private Ticket ticket;


	@ManyToOne
	@JoinColumn(name = "author_id")
	private Usuario author;


	@Column(columnDefinition = "text")
	private String message;


	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
