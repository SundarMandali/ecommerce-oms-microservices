package com.ecommerce.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Order Service is healthy");
	}

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("Order Service is running");
	}
}
