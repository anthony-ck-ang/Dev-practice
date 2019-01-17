package com.anthonyang.ds.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	/*
	 * --Map-- Benefits of Set and Map are the similar. Fast lookup by key eg.
	 * data cache (k,v) no duplicate keys, duplicate value is ok use immutable
	 * object as key eg. String
	 * 
	 * non synchronized (better performance) but can be synchronized
	 * appropriately if needed. Is preferred relative to legacy HashTable
	 * (deprecated) which is synchronized
	 * 
	 */
	private static void hashMap() {
		// programming to Map Interface.
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("James", 29);
		map1.put("John", 27);
		map1.put("Ken", null);
		System.out.println(map1);

		map1.put("Ken", 28);
		System.out.println(map1);

		System.out.println("Contains James <key>? " + map1.containsKey("James"));
		System.out.println("James Age <value>: " + map1.get("James"));

		System.out.println("--- Iterate using keySet ---");
		Set<String> names = map1.keySet(); // returns a set of all keys in map
		System.out.println(names);
		for (String name : names) {
			System.out.println(name + " " + map1.get(name));
		}

		System.out.println("--- Iterate using EntrySet ---");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet(); // returns a
																	// set of
																	// map entry
																	// (k,v)
																	// pair

		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
		}
		
		System.out.println("-------------------");
		mappings.forEach(m -> System.out.println("Another way..." + m.getKey() + " " + m.getValue()));

		names.remove("Ken"); // removing the key from the new names Set will
								// affect the original Map
		System.out.println(map1);
	}

	private static void MapOfMaps() {
		Map<String, Map<String, Object>> Courses = new HashMap<>();
		
		Map<String, Object> c1ModDetails = new HashMap<>();
		c1ModDetails.put("duration", 12);
		c1ModDetails.put("trainer", "trainer1");
		c1ModDetails.put("location", "room xyz");
		
		Map<String, Object> c2ModDetails = new HashMap<>();
		c2ModDetails.put("duration", 24);
		c2ModDetails.put("trainer", "trainer2");
		c2ModDetails.put("location", "room abc");
		
		Courses.put("C1", c1ModDetails);
		Courses.put("C2", c2ModDetails);
		
		System.out.println("Courses: " + Courses);
		
	}

	public static void main(String[] args) {
		hashMap();
		//MapOfMaps();
	}

}
