package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.Data;

@Entity
@Table (name = "ticket")
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_ticket;
	@Column(name = "title")
	private String title;
	@Column(name = "descripcion")
	private String descripcion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status", referencedColumnName = "id_status" )
	private TicketStatus id_status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario" )
    private Usuario id_usuario;
    
    
}
