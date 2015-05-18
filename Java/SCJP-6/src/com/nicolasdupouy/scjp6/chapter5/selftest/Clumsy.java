package com.nicolasdupouy.scjp6.chapter5.selftest;

public class Clumsy {
	public static void main(String[] args) {
		int j = 7;
		assert (++j > 7);
		assert (++j > 8) : "hi";
		assert (j > 10) : j = 12;
		assert (j == 12) : "Expression must return a value"; // doStuff();
		assert (j == 12) : new Clumsy();
	}

	static void doStuff() {
	}
}
