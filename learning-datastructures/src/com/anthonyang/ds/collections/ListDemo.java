package com.anthonyang.ds.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {
	
	static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static LinkedList<Integer> linkedList = new LinkedList<Integer>();
	static long startTime;
	static long endTime;
	static long duration;

	private static void removeFromList() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

		/*
		 * Foreach loop -> compiler will make the .next() called after the
		 * operation of removing element ->
		 * java.util.ConcurrentModificationException
		 */
		// for (String s : list) {
		// if (s.equals("a"))
		// list.remove(s);
		// }

		// Use this, .next() must be called before .remove()
		Iterator<String> listInter = list.iterator();
		while (listInter.hasNext()) {
			String s = listInter.next();

			if (s.equals("a")) {
				listInter.remove();
			}
		}
		System.out.println(list);
	}

	/*
	 * General rule:
	 * Use LinkedList for large number of sequential add/remove operations
	 * (faster). There are no large number of random access of element.
	 * Use ArrayList for random access get operation (by index).
	 */
	private static void addOpArryListVsLinkList() {
		// ArrayList add
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration);
		 
		// LinkedList add
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration);

	}

	public static void main(String[] args) {
		
		//removeFromList();
		addOpArryListVsLinkList();
		getOpArryListVsLinkList();
		rmOpArryListVsLinkList();
	}

	private static void rmOpArryListVsLinkList() {
		// ArrayList remove
		startTime = System.nanoTime();
		 
		for (int i = 9999; i >=0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration);
		 
		 
		// LinkedList remove
		startTime = System.nanoTime();
		 
		for (int i = 9999; i >=0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration);

		
	}

	private static void getOpArryListVsLinkList() {
		// ArrayList get
				startTime = System.nanoTime();
				 
				for (int i = 0; i < 10000; i++) {
					arrayList.get(i);
				}
				endTime = System.nanoTime();
				duration = endTime - startTime;
				System.out.println("ArrayList get:  " + duration);
				 
				// LinkedList get
				startTime = System.nanoTime();
				 
				for (int i = 0; i < 10000; i++) {
					linkedList.get(i);
				}
				endTime = System.nanoTime();
				duration = endTime - startTime;
				System.out.println("LinkedList get: " + duration);
		
	}

}
