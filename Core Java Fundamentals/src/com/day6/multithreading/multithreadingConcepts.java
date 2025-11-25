package com.day6.multithreading;

public class multithreadingConcepts {
	
	//multithreading
	//thread - single sequential flow of control within a program
	//		 - smallest independent unit of a process
	//process - may contain one or multiple threads
	//analogy - restraunt - run this - process
	//servers - threads
	//thread - has its own program counter, call stack, local variables,
	//		 - shared among threads - share memory (heap, statics variables)
	
	
	//multithreading - ability to manage multiple threads execution at same time (concurrently)
	// - can creat man threads within same jvm process
	
	//concurrency / parallelism
	// - multiple threads executing and overlapping time periods
	// - single core cpu
	// - 3 threads running - 1,2,3
	// - jvm switch b/w threads - they appear simultaneous
	// multhithreading enables concurrency
	//parallelalism - multiple cpu - threads/ processes are running simlutaneously
	
	//benefits :
	// - throughput -> server can handle multiple requests at same time
	// - better resources utilization
	
	//overheads:
	// - overhead of thread creation, switching, synchronization 
	// - add up complexity
	
	//creating thread - 2 ways
	//java.lang package
	// 1- inbuilt thread class
	// 2- implement runnable interface
	
	//Thread lifecycle:
	//- synchronize
	//- actually happens inside jvm when thread is created, started, running--
	//- describe the difference sttes that a thread goes through:
	//- from its creation until final execution until final execution or termination
	
	//1. new state - when thread is created but not started
	//			- sxists as an objected but no call stack is thread
	//thread t = new Thread() - created -> new state
	
	//2. Runnable state
	//- when you call start(), thread moves from new -> runnable
	//- ready to run and waitning for cpu time
	//- cpu scheduler will execute
	//t1.start() -> thread is now runnable
	
	//3.blocked state
	//- waiting to acquire a lock
	//- amount 
	
	//4. waiting state
	//- waiting for another thread to perform speciic action
	//- lock - T2 has occcupied amount
	//- T1 is waiting for that lock
	//- T@ finishes - notify other threads notify() notifyAll()
	//- T1 wait indefinitely - waiting state
	
	//5. Timed waiting state
	//- similar like a waiting state but for a fixxed time
	
	//6. terminated state
	//- once run(0 method finishes, thread exists - done/exception
	//- cannot be restarted
	
	//Get state t1.getState()
	
	/*
	 * NEW
	 *  |
	 * start()
	 *  |
	 * R   U   N  N   A   B   L    E
	 *  |			|				|
	 * get lock		wait/join	  sleep
	 *  |			|				|
	 * BLOCKED	   WAITING		  TIMED WAITING STATE
	 *  |____________ |____________ |
	 *  		TERMINATED
	 * */
	
	
	//Thread synchronization:
	//- multiple threads share same memory area (heap)
	//- means multiple threads can access and modify the same object or variable at the same time
	//- t1, t2, t3 - sharing amount variable
	//- if they do this without coordination then we get data inconsistency - this problem is known as Race condition
	//- amount =1000
	//- t1 (deposit on amount)
	//- t2 (withdraw from amount)
	//- t1 executing deposit which is not finished yet - 1000 - 1500
	//- mean time t2 started withdrawing -  800 - cannot withdraw - 200
	//- to solve this problem - synchronization 
	//- mechanism which ensure that a thread accesses a shared resources at a time
	//- prevent race condition by locking the shared object when no thread is using it
	//- java provides - sync methods, sync blocks
	
	//-take example - without sync
	//-apply sync methods - now execution changes
	//-movie ticket example
	
	//Static synchronization:
	
	
	//Inter -thread communication:
	//- sync unsures that only one thread works on a shared resource
	//- threads need to cooperate rather just block each other
	//- three methods are defined-
	//- wait() - thread releases the lock and enter waiting state until notified
	//- notify() - wakes up one waiting thread (Chosen randomly)
	//- notifyAll() -> wakes up all waiting threads in that object
	
	//Rules for wait() and notify()
	//- must be called inside a sync block or methods
	//- thread must own the lock before calling them 
	//- after calling wait() - thread releases the lock imediately, waiting state
	//- when another thread calls notify on some other thread, their state changes to Runnable
	
	// Producer Consumer Problem 
	//- assignment - to explore this topic and implement code for this
	
	//- Scenario based example for inter - thread - 
	//- multiple employees (Threads ) who want to use a shared printer
	//- printer - can print only one document at a time
	//- E1 - printing, others must wait
	//- when the E1 finishes, it notify the next waiting employee
	//
}
