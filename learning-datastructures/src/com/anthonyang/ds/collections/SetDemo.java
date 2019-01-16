package com.anthonyang.ds.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	/*
	 * Use Case rapid lookup, insert, delete O(1) Insertion order is not
	 * important Better for removeAll() & retainAll()
	 */

	private static void showNoDupValHashSet() {
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("b");
		set1.add("a");

		System.out.println("set1: " + set1); // no duplicate values
	}

	public static void main(String[] args) {
		showNoDupValHashSet();
	}

}
