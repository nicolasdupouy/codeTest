package com.nicolasdupouy.scjp6.chapter8.course;

public class AnonymousInnerClassFlavorWonderfulClass {
	void go() {
		Bar b = new Bar();
		b.doStuff(new Foo() {
			@Override
			public void foo() {
				System.out.println("le foufou");
			}
		});
	}
}

interface Foo {
	void foo();
}

class Bar {
	void doStuff(Foo foo) {
	};
}