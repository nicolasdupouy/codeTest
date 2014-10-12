package com.ndu.java8.functionalInterfaces.builtInFunctionalInterface.consumer;

import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		Consumer<Person> greeter = (p) -> System.out.println("Hello " + p.firstName);
		greeter.accept(new Person("Diesel", "Dupouy"));
	}
}
