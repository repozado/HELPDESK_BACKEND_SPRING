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
@Table(name= "ticket_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_status;
	@Column(name="nombre", nullable = false)
	private String nombre;	
	@Column(name="descripcion", nullable = false)
	private String descripcion;	
}
