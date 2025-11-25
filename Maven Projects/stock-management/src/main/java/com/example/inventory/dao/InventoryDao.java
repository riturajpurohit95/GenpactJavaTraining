package com.example.inventory.dao;

import java.util.List;
import java.util.Optional;

import com.example.inventory.model.Item;

public interface InventoryDao {
	
	//all CRUD methods
	
	//create a list of all methods that should be implemented for inventory management

	Long create(Item item); //create new item of type Item and return long
	
	Optional<Item> findById(Long id); //result or get null if no such id - to handle this use optional class
	
	
	List<Item> findAll(int offset, int limit); //offset - from where we have to start, limit - how many rows
	
	int update(Item item);
	
	int delete(Long id);
	
	//reduce quantity for given item 
	//return true if successful
	//false if insufficient stock
	boolean reduceQuantity(Long id, int quantityToReduce);
	
}
