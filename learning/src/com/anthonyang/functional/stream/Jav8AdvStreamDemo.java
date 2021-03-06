package com.anthonyang.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Jav8AdvStreamDemo {

	static ArrayList<Person> persons = new ArrayList<Person>(
			Arrays.asList(new Person("a", 21), new Person("b", 27), new Person("c", 27), new Person("d", 8)));

	/*
	 * Collect is an extremely useful terminal operation to transform the
	 * elements of the stream into a different kind of result, e.g. a List, Set
	 * or Map
	 */
	
	//common usecase
	private static void filterAndCollect() {
		
		List<Person> filteredList =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("a"))   
			        .collect(Collectors.toList());
		
			System.out.println(filteredList);
		
		Set<Person> filteredSet =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("a"))   
					.collect(Collectors.toSet());
			System.out.println(filteredSet);
		
	}
	
	private static void groupByAge(){
		
		Map<Integer, List<Person>> personsByAge = persons
			    .stream()
			    .collect(Collectors.groupingBy(p -> p.age));

			personsByAge
			    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
			
			System.out.println(personsByAge); //age -> (Key), list of person -> (value), {21=[a], 8=[d], 27=[b, c]}
	}
	
	public static void main(String[] args) {
		//filterAndCollect();
		groupByAge();
	}

}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}
