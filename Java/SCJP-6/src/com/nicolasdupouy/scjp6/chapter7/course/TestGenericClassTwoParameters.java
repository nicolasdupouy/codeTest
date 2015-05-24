package com.nicolasdupouy.scjp6.chapter7.course;

public class TestGenericClassTwoParameters<T, X> {
	T one;
	X two;

	TestGenericClassTwoParameters(T one, X two) {
		this.one = one;
		this.two = two;
	}

	T getT() {
		return one;
	}

	X getX() {
		return two;
	}

	// test it by creating it with <String, Integer>
	public static void main(String[] args) {
		TestGenericClassTwoParameters<String, Integer> twos = new TestGenericClassTwoParameters<String, Integer>("foo",
				42);
		String theT = twos.getT(); // returns a String
		int theX = twos.getX(); // returns Integer, unboxes to int
	}
}