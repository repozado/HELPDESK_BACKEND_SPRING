package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Rol;
import com.example.repo.IRolRepo;
import com.example.service.IRolService;

@Service
@Transactional
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolRepo repo;
	
	@Transactional
	@Override
	public List<Rol> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Optional<Rol> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public Rol create(Rol rol) {
		return repo.save(rol);
	}

	@Transactional
	@Override
	public Rol update(Integer id, Rol rol) {
		if (repo.existsById(id)) {
			rol.setIdRol(id);
			return repo.save(rol);
		}
		return null;
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
}
