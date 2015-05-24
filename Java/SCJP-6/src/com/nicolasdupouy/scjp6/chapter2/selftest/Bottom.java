package com.nicolasdupouy.scjp6.chapter2.selftest;

class Top {
	public Top() {
		System.out.println("E");
	}

	public Top(String s) {
		System.out.println("B");
	}
}

public class Bottom extends Top {
	public Bottom(String s) {
		System.out.println("D");
	}

	public static void main(String[] args) {
		new Bottom("C");
		System.out.println(" ");
	}
}