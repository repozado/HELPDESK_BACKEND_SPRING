package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.Rol;

public interface IRolService {
	List<Rol> getAll();
	Optional<Rol> findById(Integer id);
	Rol create(Rol rol);
	Rol update(Integer id, Rol rol);
	void delete(Integer id);
}
