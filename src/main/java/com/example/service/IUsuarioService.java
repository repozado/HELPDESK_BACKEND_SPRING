package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.models.Usuario;

public interface IUsuarioService {
    List<Usuario> getAll();
    Optional<Usuario> findById(Integer id);
    Usuario create(Usuario usuario);
    Usuario update(Integer id, Usuario usuario);
    void delete(Integer id);
}
