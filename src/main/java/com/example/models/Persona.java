package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor      
@AllArgsConstructor
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;

	@Column(name = "adjetivo")
	private String adjetivo;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "cedula")
	private String cedula;

	@Column(name = "ciudad")
	private String ciudad;

	@Column(name = "correo")
	private String correo;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "profesion")
	private String profesion;

	@Column(name = "puesto")
	private String puesto;

	@Column(name = "telefono")
	private String telefono;

	@ManyToOne
	@JoinColumn(name = "unit_id", referencedColumnName = "id_uni_adm")
	private UnidadAdministrativa unidadAdministrativa;
}
