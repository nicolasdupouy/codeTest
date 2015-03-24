package com.nicolasdupouy.scjp6.chapter2.selftest;

class Mammal {
	String name = "furry ";

	String makeNoise() {
		return "generic noise.";
	}
}

class Zebra extends Mammal {
	String name = "stripes ";

	String makeNoise() {
		return "bray";
	}
}

public class ZooKeeper {
	public static void main(String[] args) {
		new ZooKeeper().go();
	}

	void go() {
		Mammal m = new Zebra();
		System.out.println(m.name + m.makeNoise());
	}
}
