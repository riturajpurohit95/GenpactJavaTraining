package com.example.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item {
	
	public Item(String name, String description, BigDecimal unitPrice, Integer quantity) {
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	public Item() {
	}
	
	private Long id;
	private String name;
	private String description;
	private BigDecimal unitPrice;
	private Integer quantity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
