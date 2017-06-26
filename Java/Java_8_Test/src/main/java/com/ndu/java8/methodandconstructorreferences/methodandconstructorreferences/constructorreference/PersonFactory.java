package com.ndu.java8.methodandconstructorreferences.methodandconstructorreferences.constructorreference;

@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
