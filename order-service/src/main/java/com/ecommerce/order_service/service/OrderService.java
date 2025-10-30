package com.ecommerce.order_service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.order_service.client.InventoryClient;
import com.ecommerce.order_service.dto.OrderItemRequest;
import com.ecommerce.order_service.dto.OrderRequest;
import com.ecommerce.order_service.model.Order;
import com.ecommerce.order_service.model.OrderItem;
import com.ecommerce.order_service.model.OrderStatus;
import com.ecommerce.order_service.repo.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private InventoryClient inventoryClient;

	@Transactional
	public Order placeOrder(OrderRequest orderRequest) {
		Order order=new Order();
		order.setUserId(orderRequest.getUserId());
		order.setOrderStatus(OrderStatus.PENDING);
		order.setCreatedAt(LocalDateTime.now());
		order.setUpdatedAt(LocalDateTime.now());
		List<OrderItem> orderItems=new ArrayList<>();
		List<OrderItemRequest> successfulItems=new ArrayList<>();
		double totalAmount=0;
		try {
			for(OrderItemRequest itemRequest:orderRequest.getItems()) {
				boolean success=inventoryClient.reduceStock(itemRequest.getProductId(), itemRequest.getQuantity());
				if(!success) {
					throw new RuntimeException("Insufficient stock for product: "+itemRequest.getProductId());
				}
				successfulItems.add(itemRequest); // keep track of successful stock reductions

				OrderItem item = new OrderItem();
				item.setProductId(itemRequest.getProductId());
				item.setQuantity(itemRequest.getQuantity());
				item.setPricePerUnit(itemRequest.getPricePerUnit());
				item.setTotalPrice(itemRequest.getPricePerUnit() * itemRequest.getQuantity());
				item.setOrder(order);
				orderItems.add(item);
				totalAmount += item.getTotalPrice();
			}
			order.setOrderItems(orderItems);
			order.setTotalAmount(totalAmount);
			order.setOrderStatus(OrderStatus.CONFIRMED);
			return orderRepo.save(order);
		}catch(Exception e) {
			//Compensation: restore any reduced stock
			for (OrderItemRequest successful : successfulItems) {
				try {
					inventoryClient.increaseStock(successful.getProductId(), successful.getQuantity());
				} catch (Exception ignore) {}
			}
			throw new RuntimeException("Order failed: " + e.getMessage());
		}

	}

	public Order getOrder(Long id) {
		return orderRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Order not found: " + id));

	}

	public Order updateStatus(Long id, OrderStatus status) {
		Order order = orderRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Order not found: " + id));
		order.setOrderStatus(status);
		order.setUpdatedAt(LocalDateTime.now());
		return orderRepo.save(order);
	}

}
