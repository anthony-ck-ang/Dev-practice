package com.anthonyang.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Jav8StreamDemo {

	/*
	 * Functional Programming -> Streams are monads (design pattern/structure)
	 * structure that represents computations, defined as sequences of steps.
	 * The Structure -> chain operations, or nest functions of that type
	 * together.
	 */

	/*
	 * A stream represents a sequence of elements and supports different kind of
	 * operations to perform computations upon those elements. Stream operations
	 * are divided into intermediate and terminal operations.
	 * 
	 * Intermediate operations return a stream so that we can chain multiple
	 * 
	 * Intermediate operations are always lazy; executing an intermediate
	 * operation such as filter() does not actually perform any filtering, but
	 * instead creates a new stream that, when traversed, contains the elements
	 * of the initial stream that match the given predicate.
	 * 
	 * Processing streams lazily allows for significant efficiencies.
	 * 
	 * Traversal of the pipeline source does not begin until the terminal
	 * operation of the pipeline is executed.
	 * 
	 * Terminal operations are either void or return a non-stream result
	 */

	/*
	 * Most stream operations accept some lambda expression parameter, a
	 * functional interface specifying the exact behavior of the operation.
	 * Operations must be both non-interfering and stateless.
	 * 
	 * Non-interfering -> does not modify the underlying data source of the
	 * stream, e.g. lambda expression does not modify list by adding or removing
	 * elements from the collection.
	 * 
	 * Stateless -> execution of the operation is deterministic, e.g. lambda
	 * expression does not depends on any mutable variables or states from outer
	 * scope which might change during execution.
	 */

	static List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
	// static ArrayList<String> list = new ArrayList<String>(Arrays.asList("a1",
	// "a2", "b1", "c2", "c1"));

	private static void ETSLData() {
		list.stream().filter(a -> a.startsWith("c")) // Returns a stream
														// consisting of the
														// elements of this
														// stream that match the
														// given predicate
				.map(String::toUpperCase) // ClassName::methodName map, ->
											// transform data
				.sorted(). // sorted according to natural order
				forEach(System.out::println);// terminal operation

	}

	private static void showDiffStreams() {
		// stream() on a list of objects returns a regular object stream
		list.stream().findFirst().ifPresent(System.out::println);

		// Stream.of() to create a stream from a bunch of object references.
		// Omit creation of collection
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);

		//IntStreams can replace the regular for-loop utilizing IntStream.range()
		IntStream.range(1, 4).forEach(System.out::println);
		System.out.println(IntStream.range(1, 4).sum());
		LongStream.range(10000001, 10000005).forEach(System.out::println);

	}
	
	private static void convertStreams(){
		
	}

	public static void main(String[] args) {
		//showDiffStreams();
		convertStreams();
		// ETSLData();
	}

}
