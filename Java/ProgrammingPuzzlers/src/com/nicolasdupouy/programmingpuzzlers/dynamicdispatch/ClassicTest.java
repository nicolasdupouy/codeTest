package com.nicolasdupouy.programmingpuzzlers.dynamicdispatch;

class A {
	public void f() {
		System.out.println("A");
	}
}

class B extends A {
	public void f() {
		System.out.println("B");
	}
}

public class ClassicTest {
	public static void main(String argv[]) {
		B b = new B();
		A a = (A) b;
		a.f();
		((B) a).f();
		((A) a).f();
	}
}
