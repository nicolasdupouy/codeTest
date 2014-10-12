package com.ndu.java8.functionalInterfaces.builtInFunctionalInterface.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		Predicate<String> predicate = (s) -> s.length() > 0;

		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}
}
