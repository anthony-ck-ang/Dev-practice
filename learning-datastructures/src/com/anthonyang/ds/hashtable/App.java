package com.anthonyang.ds.hashtable;

public class App {

	public static void main(String[] args) {
		
		//initiate HT at least x2 the elements to be inserted
		
		HashTable table = new HashTable(20); 
		table.insert("bear");
		table.insert("crow");
		table.insert("purple");
		table.insert("blue");
		table.insert("self");
		table.insert("taste");
		table.insert("expand");
		table.insert("savory");
		table.insert("sweet");
		table.insert("travel");
		table.insert("time");
		table.insert("space");
		
		
		System.out.println("**---------FIND ELEMENTS---------**");
		System.out.println(table.find("time"));
		System.out.println(table.find("self"));
		System.out.println(table.find("blue"));
		System.out.println(table.find("taste"));
		System.out.println(table.find("travel"));
		
		table.displayTable();
	}

}
