package Racionais;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTester {
	
	public static void addRandomNumbers(Queue<Rational> q, int nElements, int range) {
		while(nElements > 0) {
			q.offer(new Rational((int)(Math.random() * range), (int)(Math.random() * range)));
			nElements--;
		}
	}

	public static void main(String[] args) {
		Queue<Rational> pq = new PriorityQueue<>();
		int numberOfElements = 13;
		int range = 712;
		System.out.println(".................Adding " + numberOfElements + " elements to PriorityQueue.................");
		addRandomNumbers(pq, numberOfElements, range);
		
		System.out.println("\n.................Printing PriorityQueue with \"Natural\" Order.................");
		System.out.println(pq);
		
		System.out.println("\n.................Returns first Element.................");
		System.out.println(pq.peek());
		
		System.out.println("\n.................Pool Elements.................");
		while(pq.size() > 0)
			System.out.println(pq.poll());
		
		System.out.println("Size: " + pq.size());
		
		System.out.println("\n.................With Comparator.................");
		Queue<Rational> pq1 = new PriorityQueue<>((r1,r2) -> r1.getDenominator() - r2.getDenominator());
		System.out.println(".................Adding " + numberOfElements + " elements to PriorityQueue.................");
		addRandomNumbers(pq1, numberOfElements, range);
		
		System.out.println("\n.................Printing PriorityQueue with Comparator Order.................");
		System.out.println(pq1);
		
		System.out.println("\n.................Returns first Element.................");
		System.out.println(pq1.peek());
		
		System.out.println("\n.................Pool Elements.................");
		while(pq1.size() > 0)
			System.out.println(pq1.poll());
		
		System.out.println("Size: " + pq1.size());
	}
}
