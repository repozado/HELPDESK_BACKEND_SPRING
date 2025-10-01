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
@Table(name = "unidadadministrativa")
@Data
@NoArgsConstructor      
@AllArgsConstructor
public class UnidadAdministrativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uni_adm")
    private Integer idUniAdm;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "nombreuni")
    private String nombreUni;

    @ManyToOne
    @JoinColumn(name = "id_unidadp", referencedColumnName = "id")
    private UnidadPrincipal idUnidadp;
    
}
