package com.anthonyang.functional.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthScrollBarUI;

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
		
		list.stream()
			.filter(a -> a.startsWith("c")) 
			.map(String::toUpperCase) // ClassName::methodName map, -> transform data
			.sorted() //sorted according to natural order
			.forEach(System.out::println);// terminal operation

	}

	private static void showDiffStreams() {
		// stream() on a list of objects returns a regular object stream
		list.stream()
			.findFirst()
			.ifPresent(System.out::println);

		// Stream.of() to create a stream from a bunch of object references.
		// Omit creation of collection
		Stream.of("a1", "a2", "a3")
			.findFirst()
			.ifPresent(System.out::println);

		// IntStreams can replace the regular for-loop utilizing
		// IntStream.range()
		IntStream
			.range(1, 4)
			.forEach(System.out::println);
		
		System.out.println(IntStream.range(1, 4).sum());
		
		LongStream
			.range(10000001, 10000005)
			.forEach(System.out::println);

	}

	private static void convertStreams() {

		// obj stream -> primitive int stream
		Stream.of("a1", "a2", "a3")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);

		// primitive stream -> obj stream
		IntStream.range(1, 6)
			.mapToObj(i -> "a" + i)
			.forEach(System.out::println);
			
		//double -> int -> obj stream
		Stream.of(1.0, 2.0,3.0)
			.mapToInt(Double::intValue).mapToObj(fi -> "a" + fi )
			.forEach(System.out::println);
	}

	private static void showStreamProcessOrder() {
		/*
		 * element moves and are processed vertically.
		 * a -> filter -> foreach before b ->
		 */
		Stream.of("a", "b", "c", "d", "e")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("-------------------------------------------------");
		/*
		 * anyMatch operation -> true as soon as the predicate (func I/method) 
		 * is applied to the given input element.
		 * 
		 * In order to match, map is applied to 2 elements only instead of all elements.
		 * map will be called as few as possible.
		 */
		Stream.of("e", "a", "c", "d", "b")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });	
	}
	
	private static void showStreamProcessOrder2(){
		
		/*
		 * Actual number of executions can be greatly reduce 
		 * if order of the operations is changed,
		 * moving filter to the beginning of the chain. 
		 */
		Stream.of("e", "a", "c", "d", "b")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		/*
		 *  filter: e
			filter: a
			map: a		-> only called once -> perform better for larger elements input
			forEach: A
			filter: c
			filter: d
			filter: b
		 */
	}

	private static void showStreamProcessOrder3(){
		/*
		 * Sorting -> stateful intermediate operation,
		 *  in order to sort a collection of elements you have to maintain state during ordering.
		 *  **sort is executed on the entire input collection (executed horizontally).
		 *  sort is called multiple times for multiple combinations on every element in the input collection.
		 */
		Stream.of("e", "a", "c", "d", "b")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s -> %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("-------------------------------------------------");
		
		/*
		 * sorted is never called because filter reduces the input collection to just one element.
		 * (greatly increase performance for larger input collections)
		 * Use filter*, use sort only if necessary (diff use case)
		 */
		Stream.of("e", "a", "c", "d", "b")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
	}
	
	private static void showReuseStreamException() {
		/*
		 * Java 8 streams cannot be reused. 
		 * Stream is closed when terminal operation is called.
		 */
		
		Stream<String> stream =
			    Stream.of("e", "a", "c", "d", "b")
			        .filter(s -> s.startsWith("a"));

			stream.anyMatch(s -> true);    // ok
			//stream.noneMatch(s -> true);   // exception
			
		System.out.println("-------------------------------------------------");	
		
		//supplier of stream results.
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("e", "a", "c", "d", "b")
			            .filter(s -> s.startsWith("a"));
		/*
		 * .get() -> get a result
		 *  get() -> constructs and saves a new stream -> use to call on the desired terminal operation.
		 */
		System.out.println(streamSupplier.get().anyMatch(s -> true));
		System.out.println(streamSupplier.get().noneMatch(s -> true));
		
		
	}

	
	public static void main(String[] args) {
		// showDiffStreams();
		//convertStreams();
		// ETSLData();
		//showStreamProcessOrder();
		//showStreamProcessOrder2();
		//showStreamProcessOrder3();
		showReuseStreamException();
	}	

}
