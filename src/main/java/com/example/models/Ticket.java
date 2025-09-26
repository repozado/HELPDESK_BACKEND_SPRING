package com.example.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table (name = "ticket")
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ticket;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status", referencedColumnName = "id_status" )
	private TicketStatus id_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_priority", referencedColumnName = "id_priority" )
	private TicketPriority id_priority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creador", referencedColumnName = "id_usuario" )
    private Usuario id_usuario_creador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_asignado", referencedColumnName = "id_usuario" )
    private Usuario id_usuario_asignado;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha_creacion;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha_actualizacion;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha_cierre;
	
	private Boolean cerrado;
}
