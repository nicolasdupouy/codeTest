package com.ndu.java8.functionalInterfaces.builtInFunctionalInterface.function;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		String s = backToString.apply("123");
		System.out.println(s);
		System.out.println(s.getClass());
	}

}
