package com.nicolasdupouy.scjp6.chapter7.course;

public class TestGenericClassOneParameter<T> {
	T anInstance; // as an instance variable type
	T[] anArrayOfTs; // as an array type

	TestGenericClassOneParameter(T anInstance) { // as an argument type
		this.anInstance = anInstance;
	}

	T getT() { // as a return type
		return anInstance;
	}
}