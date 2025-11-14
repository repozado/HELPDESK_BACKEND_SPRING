package com.example.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Integer idUsuario;
    private String email;
    private String nombres;
    private String apellidos;
    private boolean estado;
    private List<String> roles;
}
