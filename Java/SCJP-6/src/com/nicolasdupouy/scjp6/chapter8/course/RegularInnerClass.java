package com.nicolasdupouy.scjp6.chapter8.course;

public class RegularInnerClass {
	private int x = 7;

	class MyInner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
			System.out.println("Inner class reference is " + this);
			System.out.println("Outer class reference is "
					+ RegularInnerClass.this);
		}
	}

	public void makeInner() {
		MyInner in = new MyInner();
		in.seeOuter();
	}

	public static void main(String[] args) {
		RegularInnerClass.MyInner inner = new RegularInnerClass().new MyInner();
		inner.seeOuter();
	}

}
