package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor      
@AllArgsConstructor
@Table(name="ticket_priority")
public class TicketPriority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_priority;
	@Column( nullable = false)
	private String nombre;
	private String descripcion;
}
