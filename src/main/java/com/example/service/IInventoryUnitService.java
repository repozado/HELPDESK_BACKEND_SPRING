package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.InventoryUnit;

public interface IInventoryUnitService {
	List<InventoryUnit> getAll();
	Optional<InventoryUnit> findById(Integer id);
	InventoryUnit create(InventoryUnit inve);
	InventoryUnit update(Integer id, InventoryUnit inve);
	void delete(Integer id);
}
