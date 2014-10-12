package com.ndu.java8.LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Nicolas", "Hanane", "Joëlle", "Alain");

		System.out.println(names);

		// Classic version before Java 8 (Verbose !)
		/*Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}

		});*/

		// With lambda expressions (version 1)
		/*Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});*/

		// With lambda expressions (version 2: shorter)
		//Collections.sort(names, (String a, String b) -> b.compareTo(a));

		// With lambda expressions (version 3: Ultimate)
		Collections.sort(names, (a, b) -> b.compareTo(a));

		System.out.println(names);
	}
}
