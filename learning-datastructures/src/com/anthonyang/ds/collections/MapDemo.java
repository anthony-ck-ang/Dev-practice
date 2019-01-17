package com.anthonyang.ds.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	
	private static void hashMap() {
		//programming to Map Interface.
		Map<String, Integer> map1 = new HashMap<>(); 
		map1.put("James", 29);
		map1.put("John", 27);
		map1.put("Ken", null);
		System.out.println(map1);
		
		map1.put("ken", 28);
		System.out.println(map1);
		
		System.out.println("Contains James <key>? " + map1.containsKey("James"));
		System.out.println("James Age <value>: " + map1.get("James"));
		
	}

	public static void main(String[] args) {
		hashMap();
	}

}
