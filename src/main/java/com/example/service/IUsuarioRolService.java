package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.UsuarioRol;
import com.example.models.UsuarioRolId;

public interface IUsuarioRolService {
    List<UsuarioRol> getAll();
    Optional<UsuarioRol> findById(UsuarioRolId id);
}
