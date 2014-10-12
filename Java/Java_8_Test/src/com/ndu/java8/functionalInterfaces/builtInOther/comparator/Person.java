package com.ndu.java8.functionalInterfaces.builtInOther.comparator;

public class Person {
	String firstName;
	String lastName;

	Person() {
	}

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return "[" + firstName + " " + lastName + "]";
	}
}
