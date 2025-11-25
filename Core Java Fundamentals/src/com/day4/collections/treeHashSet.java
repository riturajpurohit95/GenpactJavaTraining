package com.day4.collections;

import java.util.TreeSet;

public class treeHashSet {

	public static void main(String[] args) {
		// HS - no order , LHs - insertion order
		// stores elements in a sorted order
		// no duplicates
		//no null value is allowed
		//internally it is maintained as Tree - red black tree(shelf balancing binary search tree)
		//has navigation methods - not there for hs, lhs
		// first(), last(), lower()...
		
		TreeSet<Integer> numbers = new TreeSet<>();
		numbers.add(100);
		numbers.add(400);
		numbers.add(300);
		numbers.add(500);
		numbers.add(200);
		System.out.println(numbers);
		
		System.out.println(numbers.contains(100));
		System.out.println(numbers.descendingSet());
		
		
		//navigation methods
		System.out.println(numbers.first());//lowest elements in the set
		System.out.println(numbers.last());
		System.out.println(numbers.ceiling(250));//return least element from -> which is greater than or equal to given element
		System.out.println(numbers.floor(900));//return greatest -> which are less than or equal to number
		System.out.println(numbers.pollFirst());
		System.out.println(numbers);
		System.out.println(numbers.pollLast());
		System.out.println(numbers);

	}

}
