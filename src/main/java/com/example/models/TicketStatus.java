package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "ticket_status")
@Data
public class TicketStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_status;
	@Column(name="status")
	private String status;	
}
