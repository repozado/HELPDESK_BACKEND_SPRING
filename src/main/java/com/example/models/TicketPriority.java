package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_priority")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TicketPriority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_priority;

	@Column(name = "nombre", nullable = false)
	private String name;

	@Column(name = "descripcion")
	private String description;

	// Tiempo máximo de resolución expresado en horas
	@Column(name = "tiempo_resolucion", nullable = false)
	private Integer resolutionTimeHours;
}
