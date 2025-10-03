package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.Persona;

public interface IPersonaService {
    List<Persona> getAll();
    Optional<Persona> findById(Integer id);
}
