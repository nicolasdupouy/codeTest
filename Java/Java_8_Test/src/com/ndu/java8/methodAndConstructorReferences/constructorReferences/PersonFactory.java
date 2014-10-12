package com.ndu.java8.methodAndConstructorReferences.constructorReferences;

@FunctionalInterface
public interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}
