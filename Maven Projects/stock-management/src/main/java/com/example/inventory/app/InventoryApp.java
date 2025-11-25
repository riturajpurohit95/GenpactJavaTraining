package com.example.inventory.app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.inventory.config.AppConfig;
import com.example.inventory.model.Item;
import com.example.inventory.service.InventoryService;

public class InventoryApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		InventoryService service = context.getBean(InventoryService.class);
		
		System.out.println("Inventory management using JDBC Template");
		
		//1. create new item
//		Item newitem = new Item("Wireless Keyboard", "Compact wireless keyboard", 
//				new BigDecimal("700.00"),50);
//		Long id = service.addItem(newitem);
//		System.out.println("Item created with id: "+id+" successfully.");
		
		//2. fetch item by id
		Long id2 = 3L;
		Optional<Item> fetched_item = service.getById(id2);
		fetched_item.ifPresent(i -> System.out.println("Fetched item : "+ i));
		
		//3. get all items
		List<Item> list = service.listItems(2, 2);
		System.out.println("Items in the list: ");
		list.forEach(item -> System.out.println(item));
		
		//4. update item
//		if (fetched_item.isPresent()) {
//			Item item = fetched_item.get();
//			item.setUnitPrice(new BigDecimal("800.00"));
//			item.setQuantity(130);
//			int rows = service.updateItem(item);
//			System.out.println("Updated rows: "+rows);
//		}
		
		
		//5. delete item
//		service.deleteItem(5L);
//		System.out.println("Item deleted successfully!");
		
		//6. reduce item
//		service.reduceQuantity(id2, 3);
//		System.out.println("Quantity reduced for id: "+id2);
		
		context.close();

		
	}

}
