package com.ShopSphere.shop_sphere.service;

import java.util.List;

import com.ShopSphere.shop_sphere.model.Order;

public interface OrderService {
	Order createOrder(Order order);
	Order getOrderById(int orderId);
	List<Order> getOrdersByUserId(int userId);
	Order updateOrderStatus(int orderId, String status);
	Order cancelOrder(int orderId);
	void deleteOrder(int orderId);
	int placeOrder(int buyerId, int productId);
}
