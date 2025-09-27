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
@Table(name = "product")
@Data
@NoArgsConstructor      
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "brand", nullable = false)
	private String brand;

	@Column(name = "description")
	private String description;

	@Column(name = "model")
	private String model;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "color")
	private String color;

	@Column(name = "performance")
	private Integer performance;

	@Column(name = "iva")
	private Boolean iva = false;

	@Column(name = "irbp")
	private Boolean irbp = false;

	@Column(name = "ice")
	private Boolean ice = false;

	@Column(name = "part_number", unique = true)
	private String partNumber;

	@Column(name = "id_olympo")
	private String idOlymPo;
}
