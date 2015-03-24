package com.nicolasdupouy.scjp6.chapter3.course;

import java.awt.Dimension;

public class ReferenceTest {

	public static void main(String[] args) {

		ReferenceTest rt = new ReferenceTest();

		rt.changeObjectReferenced();
		rt.changeStringReferenced();
		rt.changeObjectReferencedWithParameter();
	}

	private void changeObjectReferenced() {
		Dimension a = new Dimension(5, 10);
		System.out.println("a.height = " + a.height);

		Dimension b = a;
		b.height = 30;
		System.out.println("a.height = " + a.height);
	}

	private void changeStringReferenced() {
		String x = "Java";
		String y = x;

		System.out.println("y String = " + y);
		x = x + "Bean";
		System.out.println("y String = " + y);
	}

	private void changeObjectReferencedWithParameter() {
		Dimension d = new Dimension(5, 10);
		System.out.println("d.height = " + d.height);
		modify(d);
		System.out.println("d.height = " + d.height);
	}

	private void modify(Dimension dim) {
		dim.height = dim.height + 1;
		System.out.println("dim.height = " + dim.height);
	}
}
