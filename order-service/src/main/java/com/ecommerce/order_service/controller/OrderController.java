package com.ecommerce.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order_service.dto.OrderRequest;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.model.OrderStatus;
import com.ecommerce.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
		try {
			Order order=orderService.placeOrder(orderRequest);
			return ResponseEntity.ok(order);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id){
		return orderService.getOrder(id);
	}

	@PutMapping("/{id}/status")
	public Order updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
		return orderService.updateStatus(id,status);
	}
}
