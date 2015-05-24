package com.nicolasdupouy.scjp6.chapter7.course;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	static class PQsort implements Comparator<Integer> { // inverse sort
		public int compare(Integer one, Integer two) {
			return two - one; // unboxing
		}
	}

	public static void main(String[] args) {
		PriorityQueueTest priorityQueueTest = new PriorityQueueTest();
		priorityQueueTest.testOfferPeekPoll();
		System.out.println("\n\n");
		priorityQueueTest.testSorting();
	}

	private void testOfferPeekPoll() {
		int[] ia = { 1, 5, 3, 7, 6, 9, 8 }; // unordered data
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // use natural order
		for (int x : ia)
			// load queue
			pq1.offer(x);
		for (int x : ia)
			// review queue
			System.out.print(pq1.poll() + " ");
		System.out.println("");
		PQsort pqs = new PQsort(); // get a Comparator
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs); // use Comparator
		for (int x : ia)
			// load queue
			pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for (int x : ia)
			// review queue
			System.out.print(pq2.poll() + " ");
	}

	private void testSorting() {
		String[] sa = { ">ff<", "> f<", ">f <", ">FF<" }; // ordered?
		PriorityQueue<String> pq3 = new PriorityQueue<String>();
		for (String s : sa)
			pq3.offer(s);
		for (String s : sa)
			System.out.print(pq3.poll() + " ");
	}
}

