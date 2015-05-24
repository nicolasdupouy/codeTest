package com.nicolasdupouy.scjp6.chapter8.course;

interface Cookable {
	void cook();
}

public class AnonymousInnerClassFlavor2 {
	Cookable c = new Cookable() {

		@Override
		public void cook() {
			System.out.println("anonymous Cookable implementer");
		}

	};
}
