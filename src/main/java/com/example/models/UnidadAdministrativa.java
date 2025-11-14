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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidadadministrativa")
@Data
@NoArgsConstructor      
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UnidadAdministrativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uni_adm")
    private Integer idUniAdm;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "nombreuni")
    private String nombreUni;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidadp", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UnidadPrincipal idUnidadp;
    
}
