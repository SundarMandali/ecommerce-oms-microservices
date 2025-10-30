package com.ecommerce.inventory_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	private String productName;
	private Integer stockQuantity;
	private Double price;
	private LocalDateTime lastUpdated; //check why this field kept
	
	public Inventory() {
	}
	public Inventory(Long productId, String productName, Integer stockQuantity, Double price,
			LocalDateTime lastUpdated) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.stockQuantity = stockQuantity;
		this.price = price;
		this.lastUpdated = lastUpdated;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
