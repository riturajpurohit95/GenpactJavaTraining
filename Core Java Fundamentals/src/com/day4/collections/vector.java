package com.day4.collections;

import java.util.Vector;

public class vector {

	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<>();
		
		System.out.println(v+ " size: "+v.size());
		System.out.println(v+ " size: "+v.capacity());
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		System.out.println(v+ " size: "+v.size());
		v.add(11);
		System.out.println(v+ " size: "+v.capacity());
		
		v.addElement(34);
		System.out.println(v+ " size: "+v.size());
		
		System.out.println(v.get(4));
		
//		v.remove(4);
//		System.out.println(v+ " size: "+v.size());
		v.set(4, 5);
		System.out.println(v+ " size: "+v.size());
		
		System.out.println(v+ " size: "+v.size());

	}

}
