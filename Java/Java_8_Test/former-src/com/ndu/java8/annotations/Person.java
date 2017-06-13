package com.ndu.java8.annotations;

import java.lang.annotation.Repeatable;

@interface Hints {
	Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
	String value();
}

// Old school
//@Hints({ @Hint("hint1"), @Hint("hint2") })
// New school
@Hint("hint1")
@Hint("hint2")
public class Person {

	public static void main(String[] args) {

		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint); // null

		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length); // 2

		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length); // 2
	}

}
