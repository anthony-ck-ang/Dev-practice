package com.anthonyang.ds.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {

	private static void ArraysSequentialDemo() {
		String[] stringArray = new String[] { "aaa", "bbb" };
		// asList() -> most commonly used
		List<String> strings = Arrays.asList(stringArray); // fixed-size

		System.out.println("strings: " + strings);

		strings.set(0, "kkk");
		System.out.println("Updated Array: " + Arrays.toString(stringArray));

		// Creating modifiable ArrayList from an Array
		strings = new ArrayList(Arrays.asList(stringArray));

		// Showing varargs
		strings = Arrays.asList("ccc", "ddd");
		System.out.println("size: " + strings.size());

		List<String> fixedList = Arrays.asList(new String[3]); // fixed List
		System.out.println("fl size: " + fixedList.size());

		// arrays are not auto-boxeable
		// List<Integer> fixedList2 = Arrays.asList(new int[2]);
		List<Integer> fixedList3 = Arrays.asList(new Integer[2]);

		System.out.println("fl3 size: " + fixedList3.size());

		List<int[]> fixedList4 = Arrays.asList(new int[] { 1, 2, 3 });
		System.out.println("fl4 size: " + fixedList4.size());

		// Sorting: void sort(Object[]) - Uses Merge-sort with natural ordering
		// Partially sorted array: far fewer than nlog(n) comparisons
		// Almost sorted array: approx. n comparisons, where n is array size
		Arrays.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));
		// Additional Comments: Well-suited for merging 2 or more sorted arrays
		// Concatenate the arrays & sort the resulting array!!

		// Sorting: void sort(int[]) - Uses quick sort
		int[] iArray = { 23, 4, 59 };
		Arrays.sort(iArray);
		System.out.println("Sorted iArray: " + Arrays.toString(iArray));

		// void sort(T[] a, Comparator<? super T> c)

		// Binary Search: int binarySearch(int[], int);
		// returns index if element found
		// otherwise returns -(insertion point) - 1 eg. 5 ->  -(1) - 1 = -2
		// input array must be sorted. Otherwise, behavior is undefined
		System.out.println("index returned by binary search: " + Arrays.binarySearch(new int[] { 4, 23, 59 }, 5));

	}

	public static void main(String[] args) {
		ArraysSequentialDemo();
	}
}
