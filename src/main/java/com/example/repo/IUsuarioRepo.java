package com.example.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByEmail(String email);
}
