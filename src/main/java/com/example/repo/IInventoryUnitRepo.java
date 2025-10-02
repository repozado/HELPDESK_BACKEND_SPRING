package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.InventoryUnit;

public interface IInventoryUnitRepo extends JpaRepository<InventoryUnit, Integer> {

}
