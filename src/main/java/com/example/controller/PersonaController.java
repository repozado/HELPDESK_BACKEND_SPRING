package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Persona;
import com.example.service.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = service.getAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable("id") Integer id) {
        return service.findById(id)
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
