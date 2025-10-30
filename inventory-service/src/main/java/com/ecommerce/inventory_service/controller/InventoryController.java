package com.ecommerce.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("{id}")
	public Inventory getProduct(@PathVariable Long id) {
		return inventoryService.getProduct(id);
	}
	
	@GetMapping
	public List<Inventory> getAllProducts(){
		return inventoryService.getAllProducts();
	}
	
	@PostMapping
	public Inventory addProduct(@RequestBody Inventory inventory) {
		return inventoryService.addProduct(inventory);
	}
	
	@PutMapping("/{id}/reduce")
	public boolean reduceStock(@PathVariable Long id, @RequestParam int quantity) {
		return inventoryService.reduceStock(id,quantity);
	}
	
	@PutMapping("/{id}/add-stock")
	public boolean addStock(@PathVariable Long id, @RequestParam int quantity) {
		return inventoryService.addStock(id,quantity);
	}
}
