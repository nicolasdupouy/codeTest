package com.nicolasdupouy.scjp6.chapter8.course;

class Outer {
	static class Nest {
		void go() {
			System.out.println("Outer.Nest");
		}
	}
}

public class StaticNestedClass {
	static class Nest2 {
		void go2() {
			System.out.println("StaticNestedClass.Nest2");
		}
	}

	public static void main(String[] args) {
		Outer.Nest n = new Outer.Nest();
		n.go();

		Nest2 n2 = new Nest2();
		n2.go2();
	}
}
