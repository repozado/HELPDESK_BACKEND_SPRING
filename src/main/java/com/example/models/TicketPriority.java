package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="ticket_priority")
public class TicketPriority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_priority;
	private String nombre;
	private String descripcion;
}
