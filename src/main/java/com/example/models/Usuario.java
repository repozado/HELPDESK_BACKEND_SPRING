package com.example.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	private String apellidos;
	private String cedula;
	private String direccion;
	private String email;
	private Boolean estado;
	private Date fecha_nacimiento;
	private String nombres;
	private String clave;
	private String telefono;
	private int id_uni_adm;

}
