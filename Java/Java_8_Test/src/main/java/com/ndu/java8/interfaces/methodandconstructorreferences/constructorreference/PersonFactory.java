package com.ndu.java8.interfaces.methodandconstructorreferences.constructorreference;

@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
