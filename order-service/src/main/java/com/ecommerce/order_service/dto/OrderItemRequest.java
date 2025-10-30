package com.ecommerce.order_service.dto;

public class OrderItemRequest {
	private Long productId;
	private Integer quantity;
	private Double pricePerUnit;

	public OrderItemRequest() {
	}
	public OrderItemRequest(Long productId, Integer quantity, Double pricePerUnit) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
