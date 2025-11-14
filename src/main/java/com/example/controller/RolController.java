package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Rol;
import com.example.service.IRolService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rol")
public class RolController {
	@Autowired
	private IRolService service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> getAllRol() {
		List<Rol> roles = service.getAll();
		return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Rol>> getRol(@PathVariable("id") Integer id) {
		Optional<Rol> rol = service.findById(id);
		return new ResponseEntity<Optional<Rol>>(rol, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		Rol created = service.create(rol);
		return new ResponseEntity<Rol>(created, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rol> updateRol(@PathVariable("id") Integer id, @RequestBody Rol rol) {
		Rol updated = service.update(id, rol);
		return new ResponseEntity<Rol>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRol(@PathVariable("id") Integer id) {
	    try {
	        service.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
