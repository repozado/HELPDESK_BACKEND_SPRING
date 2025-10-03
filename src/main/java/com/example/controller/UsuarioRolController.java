package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.UsuarioRol;
import com.example.models.UsuarioRolId;
import com.example.service.IUsuarioRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuariorol")
public class UsuarioRolController {

    @Autowired
    private IUsuarioRolService service;

    @GetMapping
    public ResponseEntity<List<UsuarioRol>> getAllUsuarioRol() {
        List<UsuarioRol> usuarioRol = service.getAll();
        return new ResponseEntity<>(usuarioRol, HttpStatus.OK);
    }

    // Aquí recibimos los 2 IDs que forman la PK compuesta
    @GetMapping("/{idUsuario}/{idRol}")
    public ResponseEntity<Optional<UsuarioRol>> getUsuarioRol(
            @PathVariable("idUsuario") Integer idUsuario,
            @PathVariable("idRol") Integer idRol) {

        UsuarioRolId id = new UsuarioRolId(idUsuario, idRol);
        Optional<UsuarioRol> usuarioRol = service.findById(id);
        return new ResponseEntity<>(usuarioRol, HttpStatus.OK);
    }
}
