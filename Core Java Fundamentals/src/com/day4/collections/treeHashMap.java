package com.day4.collections;

//import java.util.Map;
import java.util.TreeMap;

public class treeHashMap {

	public static void main(String[] args) {
		// TreeMap - stored order by keys (asc)
		// no null keys are allowed
		//red  black tree
		//order - keys
		//firstKey(), lastKey(), 
		// higherKey(), lowerKey()
		//descendingMap() -> reverse order
		// subMap(K fromKey, K toKey) -> range of keys
		
		
		TreeMap<String, Integer> customerData =  new TreeMap<>();
		
		customerData.put("A", 23);
		customerData.put("B", 25);
		customerData.put("C", 21);
		customerData.put("E", 24);
		customerData.put("D", 19);
		
		System.out.println(customerData);
		
		System.out.println(customerData.firstKey());
		System.out.println(customerData.lastKey());
		System.out.println(customerData.higherKey("A"));
		System.out.println(customerData.lowerKey("C"));
		System.out.println(customerData.descendingMap());
		
//		customerData.subMap("A","C");
		System.out.println(customerData.subMap("A","C"));
		
	}

}
