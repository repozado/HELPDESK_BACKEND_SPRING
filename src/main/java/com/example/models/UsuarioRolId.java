package com.example.models;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

// Clase embeddable para la PK compuesta
@Embeddable
@Data
public class UsuarioRolId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idUsuario;
    private Integer idRol;

    public UsuarioRolId() {}

    public UsuarioRolId(Integer idUsuario, Integer idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }
}
