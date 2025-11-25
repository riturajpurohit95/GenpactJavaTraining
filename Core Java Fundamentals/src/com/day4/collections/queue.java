package com.day4.collections;

import java.util.Queue;
import java.util.ArrayDeque;
//import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class queue {

	public static void main(String[] args) {
		
		//
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			q.add(2);
			q.add(4);
			q.add(3);
			
			System.out.println(q);
			System.out.println(q.peek());
			System.out.println(q.poll());
		
			//priority queue
			//internally maintained as binary heap - min heap
			//head of queue retrieved first (peek() ) removed by the poll()
			//elements are getting sorted on the based on heap
			//in a min heap - parent nodes are always equal to or less than child nodes
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			pq.add(1);
			pq.add(101);
			pq.add(21);
			pq.add(210);
			pq.add(91);
			pq.offer(32);// adds ele only if possible otherwise return false
			System.out.println(pq);
			System.out.println(pq.peek());
			System.out.println(pq.poll());
		
		
			//dequeue
			Deque<Integer> dq = new ArrayDeque<>();
			dq.addFirst(23);
			dq.addLast(29);
			dq.add(3);
			
			System.out.println(dq);
		

	}

}
