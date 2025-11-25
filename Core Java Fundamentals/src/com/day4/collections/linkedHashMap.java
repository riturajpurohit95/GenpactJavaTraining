package com.day4.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMap {

	public static void main(String[] args) {
		// maintains insertion order but hashMap does not
		//maintains as linked list - slow as compared to HashMap
		
		Map<String, Double> products = new LinkedHashMap<>();
		Map<String, Double> products2 = new LinkedHashMap<>();
		
		products.put("Laptop", 57000.00);
		products.put("Mobile", 37000.00);
		products.put("TV", 127000.00);
		products.put("Tablet", 27000.00);
		
		System.out.println(products);
		
		products2.put("Watch", 7000.00);
		products2.put("Headset", 3000.00);
		
		System.out.println(products.keySet());
		System.out.println(products.values());
		
		products.remove("Laptop");
		
		System.out.println(products.entrySet());
		
		System.out.println(products.containsKey("Laptop"));
		
		System.out.println(products);
		
		products.putAll(products2);
		System.out.println(products);
		
		//for each loop
		for(Map.Entry<String,Double> mapTOset: products.entrySet()) {
			System.out.println(mapTOset.getKey() + " : " + mapTOset.getValue());
		}
		

	}

}
