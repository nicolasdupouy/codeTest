package com.ndu.java8.functionalInterfaces.builtInFunctionalInterface.supplier;

import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<Person> personSupplier = Person::new;
		Person p = personSupplier.get();

		System.out.println(p);
	}
}
