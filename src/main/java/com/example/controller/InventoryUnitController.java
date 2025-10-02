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

import com.example.models.InventoryUnit;
import com.example.service.IInventoryUnitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inventoryunit")
public class InventoryUnitController {
	@Autowired
	private IInventoryUnitService service;
	@GetMapping
	public ResponseEntity<List<InventoryUnit>> getAllInventory(){
		List<InventoryUnit> inventory = service.getAll();
		return new ResponseEntity<List<InventoryUnit>>(inventory, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<InventoryUnit>> getInventory(@PathVariable("id") Integer id){
		Optional<InventoryUnit> inventory = service.findById(id);
		return new ResponseEntity<Optional<InventoryUnit>>(inventory, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<InventoryUnit> createInventory(@RequestBody InventoryUnit inventory){
		InventoryUnit createinventory = service.create(inventory);
		return new ResponseEntity<InventoryUnit>(createinventory, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<InventoryUnit> updateInventory(@PathVariable("id") Integer id,@RequestBody InventoryUnit inventory){
		InventoryUnit updateinventory = service.update(id,inventory);
		return new ResponseEntity<InventoryUnit>(updateinventory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryUnit>deleteInventory(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<InventoryUnit>(HttpStatus.OK);
	}
}
