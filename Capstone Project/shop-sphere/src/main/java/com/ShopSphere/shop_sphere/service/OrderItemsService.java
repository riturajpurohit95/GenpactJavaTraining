package com.ShopSphere.shop_sphere.service;

import java.util.List;

import com.ShopSphere.shop_sphere.model.OrderItem;

public interface OrderItemsService {

	OrderItem createOrderItem(OrderItem item);
	OrderItem getOrderItemById(int orderItemsId);
	List<OrderItem> getOrderItemsByOrderId(int orderId);
	List<OrderItem> getOrderItemsByProductId(int productId);
	OrderItem updateItemQuantity(int orderItemsId, int quantity);
	void deleteOrderItem(int orderItemsId);
}
