package com.ecommerce.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="inventory-service",url="${inventory.service.url}")
public interface InventoryClient {

	@PutMapping("/api/inventory/{id}/reduce")
	public boolean reduceStock(@PathVariable("id") Long id,@RequestParam("quantity") int quantity);

	@PutMapping("/api/inventory/{id}/add-stock")
	public void increaseStock(@PathVariable("id") Long id, @RequestParam("quantity") int quantity);

}
