package com.ndu.java8.stream.parallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Main {

	// Initialization
	private static final int max = 5000000;
	private static final List<String> values = new ArrayList<>(max);
	static {
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
	}

	public static void main(String[] args) {

		sequentialStream();
		parallelStream();
	}

	private static void sequentialStream() {
		long t0 = System.nanoTime();

		long count = values.stream().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("Sequential sort took: %d ms", millis));

	}

	private static void parallelStream() {
		long t0 = System.nanoTime();

		long count = values.parallelStream().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("Parallel sort took: %d ms", millis));

	}

}
