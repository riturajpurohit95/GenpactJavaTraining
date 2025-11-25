package com.day4.collections;

import java.util.HashMap;
import java.util.Map;

public class hashMap {

	public static void main(String[] args) {
		// stores elements in key value pairs
		// no order of keys
		// allows one null key an multiple null values
		// values can be duplicated not keys
		//fastest implementation in all map implemetaions
		
		Map<Integer, String> employeesMap = new HashMap<>();
		Map<Integer, String> employeesMap2 = new HashMap<>();
		
		employeesMap.put(1,"A");
		employeesMap.put(2,"B");
		employeesMap.put(3,"C");
		
		System.out.println(employeesMap);
		
		employeesMap2.put(5, "E");
		employeesMap2.put(6, "F");
		
		
		System.out.println(employeesMap.keySet());
		
		employeesMap.remove(2);
		
		System.out.println(employeesMap.entrySet());
		
		System.out.println(employeesMap.containsKey(2));
		
		employeesMap.putAll(employeesMap2);
		System.out.println(employeesMap);
		
		
		

	}

}
