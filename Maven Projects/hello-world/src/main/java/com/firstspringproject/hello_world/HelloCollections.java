package com.firstspringproject.hello_world;

import java.util.List;
import java.util.Map;
import java.util.Set;
public class HelloCollections {	

	private List<String> messages;  // constructor
	private Set<Integer> numbers; // constructor
	private Map<String, String> cmap; // setter
	
	// Default constructor 
	public HelloCollections() {	
	}
	// List constructor
	public HelloCollections(List<String> messages) {
		this.messages = messages;		
	}	
	// Set constructor
	public HelloCollections(Set<Integer> nums) {
		this.numbers = nums;
		
	}	
	// map setter method for setter injection
	public void setCmap(Map<String, String> map) {
		this.cmap = map;
	}	
	public void displayAll( ) {
		System.out.println("Constructor injected list.");
		if(messages != null) {
			for(String m : messages) System.out.println("Msg : "+ m);
		}
		else {
			System.out.println("No Messages.");
		}
		
		System.out.println("Constructor injected Set.");
		if(numbers != null) {
			for(Integer n : numbers) System.out.println("No : "+ n);
		}
		else {
			System.out.println("No Numbers.");
		}
		
		System.out.println("Setter injected Map");
		if(cmap != null) {
			
			cmap.forEach((k,v) -> System.out.println(k + " -> "+ v));			
		}
		else {
			System.out.println("No Map");
		}
		
		
		
	}
	

}
