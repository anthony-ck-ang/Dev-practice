package com.anthonyang.ds.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

	/*
	 * HashTable No duplicate keys, duplicate value is ok, 1 key -> 1 value is
	 * ok, 1 null key
	 * 
	 * Hashset -> hash table implementation of Set interface
	 * 
	 * Use Case rapid lookup, insert, delete O(1) Insertion order is not
	 * important Better for removeAll() & retainAll()
	 * 
	 * uses hashmap internally (k,v)
	 */

	private static void HashSet() {
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("b");
		set1.add("a");

		System.out.println("set1: " + set1); // no duplicate values
	}

	/*
	 * LinkedHashSet == hash table + linked list implementation of Set interface
	 * insertion order preserved + fast O(1), very fast lookup, insertion, deletion O(1)
	 * better for removeAll() & retainAll()
	 * 
	 */

	private static void linkedHashSet() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("aaaaa");
		hashSet.add("bbbbb");
		hashSet.add("ccccc");
		System.out.println("hashSet: " + hashSet);

		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("aaaaa");
		linkedHashSet.add("bbbbb");
		linkedHashSet.add("ccccc");
		System.out.println("linkedHashSet: " + linkedHashSet); // order
																// preserved	
	}

	
	public static void main(String[] args) {
		HashSet();
		Book b1 = new Book("tsaingaf", "mrk manson", 2016); // both will return
															// diff hashcode
															// (memory address
															// of obj, after int
															// conversion)
		Book b2 = new Book("tsaingaf", "mrk manson", 2016);

		Set<Book> set2 = new HashSet<Book>();
		set2.add(b1);
		set2.add(b2);
		System.out.println("set2: " + set2);

		linkedHashSet();
	}

}

class Book {
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	/*
	 * Always override hashcode when you override equals -> to unique yet equal
	 * objects
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	// @Override
	// public int hashCode() {
	// return title.hashCode(); //both obj will return same hashcode
	// }
	//
	// //overide equal method used by object class internally as it uses "=="
	// thus obj ref will be different
	// @Override
	// public boolean equals(Object obj) {
	// return (year == (((Book)obj).getYear())) &&
	// (author.equals((((Book)obj).getAuthor())));
	// }
	//

}
