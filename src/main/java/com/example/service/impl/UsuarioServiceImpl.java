package com.example.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Usuario;
import com.example.repo.IUsuarioRepo;
import com.example.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repo;

    @Override
    public List<Usuario> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {
        usuario.setIdUsuario(id);
        return repo.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
