package com.anthonyang.ds.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	private static void collectionsDemo() {
		// boolean addAll(Collection<? super T> c, T... elements);
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		String[] array = { "d" };

		// list.addAll(Arrays.asList(array));
		/*
		 * is identical to that of c.addAll(Arrays.asList(elements)), but this
		 * method is likely to run significantly faster under most
		 * implementations.
		 */
		Collections.addAll(list, array);
		System.out.println("list: " + list);

		/*
		 * static <T extends Comparable<? super T>> void sort(List<T> list)
		 * Sorts the specified list into ascending order, according to the
		 * natural ordering of its elements. All elements in the list must
		 * implement the Comparable interface
		 */
		Collections.sort(list);
		System.out.println("Sorted list: " + list);

		/*
		 * <T> int binarySearch(List<? extends Comparable<? super T>> list, T
		 * key) Needs to be sorted. O(log(n)). If not sorted results are
		 * undefined. Might perform an inefficient linear search!! For Sets:
		 * HashSet ~ O(1). TreeSet ~ O(log(n)), i.e., same efficiency as binary
		 * search Note: List.contains is O(n)
		 */
		System.out.println("Is e There? : " + Collections.binarySearch(list, "e"));

		System.out.println("-----------------------------------------------------------------");
		// <T> int binarySearch(List<? extends T> list, T key, Comparator<?
		// super T> c)

		Collections.reverse(list);
		System.out.println("Reverse list: " + list);

		Collections.swap(list, 0, 3);
		System.out.println("After swapping: " + list);

		System.out.println("# a's: " + Collections.frequency(list, "a"));

		Collections.shuffle(list);
		System.out.println("Shuffled list: " + list);

		System.out.println("Max: " + Collections.max(list)); // natural ordering
		System.out.println("Min: " + Collections.min(list));

		System.out.println("-----------------------------------------------------------------");
		/*
		 * Singleton ~ <T> Set<T> singleton(T o) Returns an immutable set
		 * containing only the specified object Others: <T> List<T>
		 * singletonList(T o) & <K,V> Map<K,V> singletonMap(K key, V value)
		 */
		// Removes from this list all of its elements that are contained in the
		// specified collection
		list.removeAll(Collections.singleton("a"));
		System.out.println(list);

		System.out.println("-----------------------------------------------------------------");
		// Unmodifiable View ~ to provide clients with read-only access to
		// internal collections
		Collection<String> unmodifiable = Collections.unmodifiableCollection(list);
		System.out.println("unmodifiable: " + unmodifiable);
		System.out.println("Is a there?: " + unmodifiable.contains("a"));
		// unmodifiable.add("a"); //java.lang.UnsupportedOperationException
		list.add("a");
		System.out.println("unmodifiable 2: " + unmodifiable);

		//https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
	}

	public static void main(String[] args) {
		collectionsDemo();
	}

}
