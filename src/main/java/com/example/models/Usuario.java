package com.example.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name= "usuario")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="cedula")
	private String cedula;
	@Column(name="direccion")
	private String direccion;
	@Column(name="email")
	private String email;
	@Column(name="estado")
	private Boolean estado;
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	@Column(name="nombres")
	private String nombres;
	@Column(name="clave")
	private String clave;
	@Column(name="telefono")
	private String telefono;
	@Column(name="id_uni_adm")
	private int id_uni_adm;

}
