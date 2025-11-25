package com.day4.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
//import java.util.ListIterator;

public class linkedHashSet {

	public static void main(String[] args) {
		// maintains the insertion order
		//slightly slow than HashSet
		//both nuniqueness and iteration order
		//org - visitors - id, keep a check on visit order
		
		LinkedHashSet<Integer> visitors = new LinkedHashSet<>();
		
		visitors.add(1);
		visitors.add(2);
		visitors.add(3);
		visitors.add(4);
		System.out.println(visitors);
		
		List<Integer> visitor = Arrays.asList(11,12,13);
		
		visitors.addAll(visitor);
		System.out.println(visitors);
		
		visitors.remove(2);
		System.out.println(visitors);
		
		visitors.removeAll(visitor);
		System.out.println(visitors);
		
		
		System.out.println(visitors.contains(13));
		
		System.out.println(visitors.isEmpty());
		
		//using iterator
		System.out.println("using iterator");
		Iterator<Integer> itr = visitors.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		
	}

}
