package com.ndu.java8.map;

import java.util.HashMap;
import java.util.Map;

public class Main {
	private static final Map<Integer, String> map = new HashMap<>();
	static {
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
	}

	public static void main(String[] args) {

		map.forEach((id, val) -> System.out.println(val));

		computeCodeOnTheMap();
		removeEntries();

		System.out.println(map.getOrDefault(42, "not found")); // not found

		merge();
	}

	private static void computeCodeOnTheMap() {
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println(map.get(3)); // val33

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9)); // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23)); // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3)); // val33

		/*map.computeIfPresent(3, (num, val) -> "bam");
		System.out.println(map.get(3)); // bam*/
	}

	private static void removeEntries() {
		map.remove(3, "val3");
		System.out.println(map.get(3)); // val33

		map.remove(3, "val33");
		System.out.println(map.get(3)); // null
	}

	private static void merge() {
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9)); // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9)); // val9concat
	}

}
