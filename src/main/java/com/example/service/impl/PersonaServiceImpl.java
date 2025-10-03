package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.example.models.Persona;
import com.example.repo.IPersonaRepo;
import com.example.service.IPersonaService;

@Service
@Transactional
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepo repo;

    @Override
    public List<Persona> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Persona> findById(Integer id) {
        return repo.findById(id);
    }
}
