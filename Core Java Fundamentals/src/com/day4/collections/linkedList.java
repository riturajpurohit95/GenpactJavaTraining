package com.day4.collections;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;
//import java.util.ListIterator;

public class linkedList {

	public static void main(String[] args) {
		
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(5);
		
		System.out.println(list);
		
		list.addFirst(0);
		System.out.println(list);
		
		list.addLast(6);
		System.out.println(list);
		
		list.remove(3);
		System.out.println(list);
		
		list.removeFirst();
		System.out.println(list);
		
		list.removeLast();
		System.out.println(list);
		
		System.out.println(list.contains(4));
		
		Collections.sort(list);
		System.out.println(list);
		
		list.forEach((l) -> {System.out.println(list.indexOf(l)+" : "+l);});
		
		//linkedlist ->  |ele1| -> |ele2| -> |ele3|
		//ele link -> points to ele2 -> link points to ele3....
		//addFrist - space - add eleN - link it to ele1
		//frequent additions and deletion - go for linkedlist
		
		
		//Arraylist -> stored in continuous memory locations
		// |ele1| - ? - |ele2| - |ele3| - |ele4|
		
		list.add(1,7);
		System.out.println(list);
		
		
		//ListIterator
		System.out.println("using iterator");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("using iterator 2");
		ListIterator<Integer> itr2  = list.listIterator(2);
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}

	}

}
