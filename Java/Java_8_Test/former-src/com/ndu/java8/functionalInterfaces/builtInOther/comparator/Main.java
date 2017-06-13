package com.ndu.java8.functionalInterfaces.builtInOther.comparator;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("Hanane", "Dupouy");
		Person p2 = new Person("Nicolas", "Dupouy");

		System.out.println(comparator.compare(p1, p2));
		System.out.println(comparator.reversed().compare(p1, p2));
	}

}
