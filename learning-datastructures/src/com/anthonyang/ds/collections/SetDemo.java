package com.anthonyang.ds.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	/*
	 * Use Case rapid lookup, insert, delete O(1) Insertion order is not
	 * important Better for removeAll() & retainAll()
	 */

	private static void HashSet() {
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("b");
		set1.add("a");

		System.out.println("set1: " + set1); // no duplicate values
	}

	public static void main(String[] args) {
		HashSet();
		Book b1 = new Book("tsaingaf","mrk manson", 2016); //both will return diff hashcode (memory address of obj, after int conversion)
		Book b2 = new Book("tsaingaf","mrk manson", 2016);
		
		Set<Book> set2 = new HashSet<Book>();
		set2.add(b1);
		set2.add(b2);
		System.out.println("set2: " +  set2);
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

	@Override
	public int hashCode() {
		return title.hashCode(); //both obj will return same hashcode
	}

	//overide equal method used by object class internally as it uses "==" thus obj ref will be different
	@Override
	public boolean equals(Object obj) {
		return (year == (((Book)obj).getYear())) && (author.equals((((Book)obj).getAuthor())));
	}
	
	
	
}
