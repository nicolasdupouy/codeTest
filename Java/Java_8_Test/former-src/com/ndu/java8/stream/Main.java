package com.ndu.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	private final static List<String> stringCollection = new ArrayList<>();
	static {
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
	}

	public static void main(String[] args) {

		System.out.println("-- filter:");
		filter();
		System.out.println("####################" + "\n");

		System.out.println("-- sorted:");
		sorted();
		System.out.println(stringCollection);
		System.out.println("####################" + "\n");

		System.out.println("-- map:");
		map();
		System.out.println("####################" + "\n");

		System.out.println("-- match:");
		match();
		System.out.println("####################" + "\n");

		System.out.println("-- count:");
		count();
		System.out.println("####################" + "\n");

		System.out.println("-- reduce:");
		reduce();
		System.out.println("####################" + "\n");
	}

	private static void filter() {
		stringCollection
				.stream()
				.filter(s -> s.startsWith("a"))
				.forEach(System.out::println);
	}

	private static void sorted() {
		stringCollection
				.stream()
				.sorted()
				.filter(s -> s.startsWith("a"))
				.forEach(System.out::println);
	}

	private static void map() {
		stringCollection
				.stream()
				.map(String::toUpperCase)
				.sorted((a, b) -> a.compareTo(b))
				.forEach(System.out::println);
	}

	private static void match() {
		boolean anyStartWithA =
				stringCollection
						.stream()
						.anyMatch(s -> s.startsWith("a"));
		System.out.println(anyStartWithA);

		boolean allStartWithA =
				stringCollection
						.stream()
						.allMatch(s -> s.startsWith("a"));
		System.out.println(allStartWithA);

		boolean noneStartWithZ =
				stringCollection
						.stream()
						.noneMatch(s -> s.startsWith("z"));
		System.out.println(noneStartWithZ);
	}

	private static void count() {
		long startWithB =
				stringCollection
						.stream()
						.filter(s -> s.startsWith("a"))
						.count();
		System.out.println(startWithB);
	}

	private static void reduce() {
		Optional<String> reduced =
				stringCollection
						.stream()
						.sorted()
						.reduce((a, b) -> a + "#" + b);
		reduced.ifPresent(System.out::println);
	}
}
