package com.ShopSphere.shop_sphere.model;

import java.math.BigDecimal;

public class OrderItem {
	
	public OrderItem(int orderItemsId, int orderId, int productId, String productName, int quantity, BigDecimal unitPrice,
			BigDecimal totalItemPrice) {
		this.orderItemsId = orderItemsId;
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalItemPrice = totalItemPrice;
	}

	private int orderItemsId;
	private int orderId;
	private int productId;
	private String productName;
	private int quantity;
	private BigDecimal unitPrice;
	private BigDecimal totalItemPrice;
	
	public OrderItem() {}

	public int getOrderItemsId() {
		return orderItemsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public BigDecimal getTotalItemPrice() {
		return totalItemPrice;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setTotalItemPrice(BigDecimal totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemsId=" + orderItemsId + ", orderId=" + orderId + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", totalItemPrice=" + totalItemPrice + "]";
	}

}
