package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory_unit")
@Data
@NoArgsConstructor      
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InventoryUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @Column(name = "municipal_code")
    private String municipalCode;

    @Column(name = "serial", unique = true)
    private String serial;

    @Column(name = "max_stock")
    private Integer maxStock;

    @Column(name = "min_stock")
    private Integer minStock;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "custodian_id", referencedColumnName = "id_persona")
    private Persona custodian;

    @Column(name = "url_img")
    private String urlImg;
}
