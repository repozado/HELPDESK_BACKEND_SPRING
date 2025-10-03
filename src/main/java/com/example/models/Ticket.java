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

import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ticket;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descripcion", columnDefinition = "text")
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status", nullable = false)
	private TicketStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_priority")
	private TicketPriority priority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creador", nullable = false)
	private Usuario usuario_creador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_asignado", referencedColumnName = "id_usuario")
	private Usuario usuario_asignado;

	@ManyToOne
	@JoinColumn(name = "inventory_unit")
	private InventoryUnit equipoAfectado;

	@Column(name = "fecha_creacion", updatable = false)
	@CreationTimestamp
	private LocalDateTime fecha_creacion;
	@UpdateTimestamp
	private LocalDateTime fecha_actualizacion;

	private LocalDateTime fecha_cierre;

	@PreUpdate
	protected void onUpdate() {

		if (this.status != null && "CERRADO".equalsIgnoreCase(this.status.getNombre())) {

			this.fecha_cierre = LocalDateTime.now();
		} else {
			this.fecha_cierre = null;
		}
	}

}