package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.InventoryUnit;
import com.example.repo.IInventoryUnitRepo;
import com.example.service.IInventoryUnitService;

@Service
@Transactional
public class InventoryUnitServiceImpl implements IInventoryUnitService {

	@Autowired
	private IInventoryUnitRepo repo;
	
	@Transactional
	@Override
	public List<InventoryUnit> getAll() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public Optional<InventoryUnit> findById(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public InventoryUnit create(InventoryUnit inve) {
		return repo.save(inve);
	}

	@Transactional
	@Override
	public InventoryUnit update(Integer id, InventoryUnit inve) {
		if(repo.existsById(id)){
			inve.setId(id);
			return repo.save(inve);
		}
		return null;
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		if(repo.existsById(id)){
			repo.deleteById(id);
		}
	}

}
