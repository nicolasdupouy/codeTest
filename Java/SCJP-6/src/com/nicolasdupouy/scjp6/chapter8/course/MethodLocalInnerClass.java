package com.nicolasdupouy.scjp6.chapter8.course;

public class MethodLocalInnerClass {
	private String x = "Outer";

	void doStuff(int parameterValue) {

		final String z = "local variable";
		class MyInner {
			public void seeOuter(int parameterValue) {
				System.out.println("Outer x is " + x);
				System.out.println("Local variable z is " + z);
			}
		}

		MyInner inner = new MyInner();
		inner.seeOuter(parameterValue);
	}

	public static void main(String[] args) {
		MethodLocalInnerClass outer = new MethodLocalInnerClass();
		outer.doStuff(8);
	}
}
