package com.day4.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class hashSet {

	public static void main(String[] args) {
		
		// stores elements in a hash table
		// does not mantain the insertion order - 1,2,3
		// fastest implementation -> add, remove, search, O(1)
		// unique elements, permits only one null value
		// store ids of employees
		// emp name -> cannot use set, Arraylist
		
		HashSet<String> empIds = new HashSet<>();
		
		empIds.add("E101");
		empIds.add("E102");
		empIds.add("E103");
		empIds.add("E104");
		empIds.add("E105");
		System.out.println(empIds);
		
		for(String s: empIds) {
			System.out.println(s);
		}
		
		System.out.println(empIds.isEmpty());
		
		List<String> newIds = Arrays.asList("E106","E107","E108");
		
		empIds.addAll(newIds);
		System.out.println(empIds);
		
		empIds.remove("E101");
		
		System.out.println(empIds.contains("E101"));
		
		System.out.println(empIds.size());
		
//		empIds.clear();
		
		empIds.removeAll(newIds);
		
		System.out.println(empIds);
		
		//clone()
		@SuppressWarnings("unchecked")
		HashSet<String> copyIds = (HashSet<String>) empIds.clone();
		System.out.println(copyIds);
		
		
		
		
		}

}
