package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}
