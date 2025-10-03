package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.example.models.UsuarioRol;
import com.example.models.UsuarioRolId;
import com.example.repo.IUsuarioRolRepo;
import com.example.service.IUsuarioRolService;

@Service
@Transactional
public class UsuarioRolServiceImpl implements IUsuarioRolService {

    @Autowired
    private IUsuarioRolRepo repo;

    @Override
    public List<UsuarioRol> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<UsuarioRol> findById(UsuarioRolId id) {
        return repo.findById(id);
    }
}
