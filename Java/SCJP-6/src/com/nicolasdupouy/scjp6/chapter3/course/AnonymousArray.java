package com.nicolasdupouy.scjp6.chapter3.course;

public class AnonymousArray {
	void takesAnArray(int[] array) {

	}

	public static void main(String[] args) {
		AnonymousArray aa = new AnonymousArray();
		aa.takesAnArray(new int[] { 1, 2, 3, 4 });
	}
}
