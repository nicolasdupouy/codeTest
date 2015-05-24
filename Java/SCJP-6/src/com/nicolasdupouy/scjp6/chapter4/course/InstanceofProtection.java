package com.nicolasdupouy.scjp6.chapter4.course;

class A {
	public void doStuff() {
		System.out.println("doStuff => A");
	}
}

class B extends A {
	public void doStuff() {
		System.out.println("doStuff => B");
	}

	public void doBStuff() {
		System.out.println("'a' refers to a B");
	}
}

public class InstanceofProtection {

	public static void main(String[] args) {
		A myA = new B();
		methodOne(myA);
		methodTwo(myA);
	}

	public static void methodOne(A a) {
		a.doStuff();
	}

	public static void methodOne(B b) { // never called because there is no
										// dynamic dispatch !
		b.doStuff();
	}

	public static void methodTwo(A a) {
		if (a instanceof B) {
			((B) a).doBStuff();
		}
	}
}
