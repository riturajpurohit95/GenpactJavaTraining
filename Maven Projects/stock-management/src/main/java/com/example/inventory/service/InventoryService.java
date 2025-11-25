package com.example.inventory.service;

import java.util.List;
import java.util.Optional;

import com.example.inventory.dao.InventoryDao;
import com.example.inventory.model.Item;

public class InventoryService {
	
	private InventoryDao dao;
	
	public InventoryService(InventoryDao dao) {
		this.dao = dao;
	}
	
	//service methods:
	
	public Long addItem(Item item) {
		return dao.create(item);
	}
	
	public Optional<Item> getById(Long id){
		return dao.findById(id);
	}
	
	public  List<Item> listItems(int offset, int limit){
		return dao.findAll(offset, limit);
	}
	
	public int updateItem(Item item) {
		return dao.update(item);
	}
	
	public int deleteItem(Long id) {
		return dao.delete(id);
	}
	
	public boolean reduceQuantity(Long id, int quantityToReduce) {
		return dao.reduceQuantity(id, quantityToReduce);
	}

}
