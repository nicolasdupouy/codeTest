package com.nicolasdupouy.scjp6.chapter7.course;

import java.util.ArrayList;
import java.util.List;

public class TestBadLegacy {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		Inserter in = new Inserter();
		in.insert(myList); // pass List<Integer> to legacy code
		System.out.println(myList);
	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		//list.add(new Integer(42)); // adds to the incoming list
		//list.add(new String("42"));
		list.add(new MyDog("Wolfie"));
	}
}

class MyDog {
	String name;

	MyDog(String name) {
		this.name = name;
	}
}
