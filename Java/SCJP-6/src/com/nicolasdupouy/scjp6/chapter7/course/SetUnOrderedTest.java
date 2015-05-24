package com.nicolasdupouy.scjp6.chapter7.course;

import java.util.Set;
import java.util.TreeSet;

public class SetUnOrderedTest {
	public static void main(String[] args) {
		boolean[] ba = new boolean[5];
		//Set<Object> s = new HashSet<Object>();
		Set<Object> s = new TreeSet<Object>();
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a");
		ba[4] = s.add(new Object());
		ba[3] = s.add("c");
		for (int x = 0; x < ba.length; x++)
			System.out.print(ba[x] + " ");
		System.out.println("\n");
		for (Object o : s)
			System.out.print(o + " ");
	}
}

