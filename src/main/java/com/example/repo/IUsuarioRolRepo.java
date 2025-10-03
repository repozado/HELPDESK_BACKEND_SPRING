package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.UsuarioRol;
import com.example.models.UsuarioRolId;

public interface IUsuarioRolRepo extends JpaRepository<UsuarioRol, UsuarioRolId> {
}
