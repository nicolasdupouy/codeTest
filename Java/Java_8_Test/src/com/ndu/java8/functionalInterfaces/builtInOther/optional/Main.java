package com.ndu.java8.functionalInterfaces.builtInOther.optional;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("bam");

		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("fallback"));

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));
	}

}
