package com.nicolasdupouy.scjp6.chapter8.course;

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

public class AnonymousInnerClassFlavor1 {
	Popcorn p = new Popcorn() {
		public void pop() {
			System.out.println("anonymous popcorn");
		}

		public void sizzle() {
			System.out.println("anonymous sizzling popcorn");
		}
	};

	public void popIt() {
		p.pop();
		// p.sizzle(); => Not defined in class Popcorn !
	}
}
