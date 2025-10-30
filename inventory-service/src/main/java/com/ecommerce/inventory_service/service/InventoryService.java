package com.ecommerce.inventory_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.inventory_service.model.Inventory;
import com.ecommerce.inventory_service.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepo;

	public Inventory getProduct(Long id) {
		return inventoryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public List<Inventory> getAllProducts() {
		return inventoryRepo.findAll();
	}

	public Inventory addProduct(Inventory inventory) {
		inventory.setLastUpdated(LocalDateTime.now());
		return inventoryRepo.save(inventory);
	}

	@Transactional
	public boolean reduceStock(Long id, int quantity) {
		Inventory product=inventoryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));

		if(product.getStockQuantity()<quantity) {
			return false;
		}
		product.setStockQuantity(product.getStockQuantity()-quantity);
		product.setLastUpdated(LocalDateTime.now());
		inventoryRepo.save(product);
		return true;
	}

	@Transactional
	public boolean addStock(Long id, int quantity) {
		Inventory product=inventoryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		product.setStockQuantity(product.getStockQuantity()+quantity);
		product.setLastUpdated(LocalDateTime.now());
		inventoryRepo.save(product);
		return true;
	}
}
