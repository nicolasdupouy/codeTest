package com.nicolasdupouy.scjp6.chapter6.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	private static final String SOURCE_STRING = "yyxxxyxx";
	private static final String PATTERN_STAR_GREEDY = ".*xx";
	private static final String PATTERN_STAR_RELUCTANT = ".*?xx";

	// private static final String PATTERN_QUESTION_MARK_GREEDY = ".?xx";
	// private static final String PATTERN_QUESTION_MARK_RELUCTANT = ".??xx";

	public TestRegex() {
	}

	public static void main(String[] args) {

		TestRegex tr = new TestRegex();
		tr.test(SOURCE_STRING, PATTERN_STAR_GREEDY);
		tr.test(SOURCE_STRING, PATTERN_STAR_RELUCTANT);
		// tr.test(SOURCE_STRING, PATTERN_QUESTION_MARK_GREEDY);
		// tr.test(SOURCE_STRING, PATTERN_QUESTION_MARK_RELUCTANT);
	}

	private void test(String sSource, String sPattern) {
		System.out.println("Testing pattern: " + sPattern);
		Pattern pattern = Pattern.compile(sPattern);
		Matcher matcher = pattern.matcher(sSource);

		showResults(matcher);
		System.out.println();
	}

	private void showResults(Matcher matcher) {
		while (matcher.find()) {
			System.out.println(matcher.start() + " : " + matcher.group()
			/* SOURCE_STRING.substring(matcher.start(), matcher.end()) */);
		}
	}
}
