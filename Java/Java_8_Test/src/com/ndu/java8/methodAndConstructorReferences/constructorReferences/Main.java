package com.ndu.java8.methodAndConstructorReferences.constructorReferences;

public class Main {

	public static void main(String[] args) {
		PersonFactory<Person> personFactory = Person::new;
		Person hanounti = personFactory.create("Hanane", "Dupouy");

		System.out.println("Great wife: " + hanounti);
	}
}
