package com.day4.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class arrayList {

	public static void main(String[] args) {
		// resizable array
		// dynamic array
		//get(0, set() -> provides fast random access
		
		ArrayList<String> gadgets = new ArrayList<>();
		
		gadgets.add("Laptop");
		gadgets.add("Mobile");
		gadgets.add("Tablet");
		gadgets.add("iPad");
		
		System.out.println("Fist element: "+ gadgets.get(0));
		
		gadgets.set(2,"Digital Camera");
		System.out.println("After ading " + gadgets.get(2) + " at index " + gadgets.indexOf("Digital Camera") + " the list is: " + gadgets);
		
		gadgets.remove("Laptop");
		System.out.println("After removing Laptop : "+gadgets);
		
		for(String g: gadgets) {
			System.out.println("Element at index " + gadgets.indexOf(g) +" : "+ g);
		}
		
		
		//searching
		System.out.println("Contains Laptop: ?" + gadgets.contains("Laptop"));
//		System.out.println(gadgets.getLast());
		
		gadgets.forEach((g) -> {System.out.println(g);});
		
		System.out.println(gadgets.isEmpty());
		
		
		
		//sorting
		//asc 
		Collections.sort(gadgets);
		System.out.println(gadgets);
		// decs
		Collections.sort(gadgets, Collections.reverseOrder());
		System.out.println(gadgets);
		
		
		//iterate using iterator
		System.out.println("using iterator");
		Iterator<String> itr = gadgets.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ListIterator<String> itr2  = gadgets.listIterator(2);
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
		
	}

}
