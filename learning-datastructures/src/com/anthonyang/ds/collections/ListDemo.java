package com.anthonyang.ds.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ListDemo {

	private static void removeFromList() {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

		/*
		 * Foreach loop -> compiler will make the .next() called after the
		 * operation of removing
		 * element -> java.util.ConcurrentModificationException
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

	public static void main(String[] args) {
		removeFromList();
	}

}
