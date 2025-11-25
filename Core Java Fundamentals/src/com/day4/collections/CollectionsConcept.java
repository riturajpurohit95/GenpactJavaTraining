package com.day4.collections;

public class CollectionsConcept {
	
	// collections : an object that groups multiple elements into a single unit
	// Array -> BankAccount() - fixed size ans simple
	
	// more powerful and more flexible 
	// Java - collection framework - java.util
	//provides standardized interfaces and implementations
	//common data structures - list of BankAccount(),
	//						 - sets, maps, queues
	// algorithms - predefined for these daa structures - sorting, searching

	//https://data-flair.training/blogs/collection-framework-in-java/
	
	
	//list interface :  - ordered collection of elements
	//					- allow duplicate elements
	//					- provides positionla access
	//					- mantains the insertion order
	//					- supports iteration - using loops , iterators, streams
	//					- implementations - arraylist, linkedlist, vector
	//					- vector - dynamic array - similar to arraylist
	//							 - grow and shrink 
	//							 - synchronized collection - thread safe - in multithread env use vector
	//							 - access time - fast access - based on index
	//							 - default capacity - 10 elements initaially 
	//							 - 10 elements - vector gets full - how grows? -> 
	//							 - increases the capacity by 100% - doubled - 20 elements now..
	//							 - size method - capcity(), addElement(), add()...
	//					- Default - ArrayList - simple, compact, fast, random access
	//					- LinkedList - frequent additions and removals in the middle/end
	//					- Vector - very rarely, costly, synchronized every method - needed
	//					- banckAccount - collection - arrayList
	
	
	//Iterator - is an object allows you to traverse throw elements of a collection
	//ArrayList, LL,Vector - creat an iterator object 
	//certain methods- hasNext() - return True if we have more lements to iterate
	//next() -> return the next element in the iteration 
	
	
	//Set Interface 
	//SEt -> collections of elements - no duplicate elements 
	// -> elements must be unique
	//-> implementations differ by ordering and performance of the set
	//HashSet, LinkedHashSet, TreeSet
	
	
	//Map Interface 
	//- java collections stored in key value pair
	//-- each key is unique
	//- values can be duplicated but not keys
	//- 3 implementation - HashMap, LinkedListMap, TreeMap
	
	
	//Queue-
	//- FIFO 
	//- collection of elements waiting to be processed
	//- tickets
	//- front end(deletion) , rear end(insertions)
	
	// LinkedList - implemens both list and queue - general purpose queue
	
	//priority queue
	//- higher priority 
	
	
	//- faster than linkedlist
	//- does not allow null elements
	
	//assignment - queue implementation code
	
	 
}
