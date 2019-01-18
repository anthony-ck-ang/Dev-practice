package com.anthonyang.ds.collections;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
	
	private static void ArraysDemo() {
		String[] stringArray = new String[]{"aaa", "bbb"};
		// asList() -> most commonly used
		List<String> strings = Arrays.asList(stringArray); // fixed-size

		System.out.println("strings: " + strings);		
	}

	public static void main(String[] args) {
		ArraysDemo();
	}
}
