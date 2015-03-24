package com.nicolasdupouy.scjp6.chapter3.course;

public class WrapperEquality {
	public static void main(String[] args) {
		WrapperEquality wrapperEquality = new WrapperEquality();
		wrapperEquality.testInteger10();
		wrapperEquality.testInteger140();
		wrapperEquality.testString();
	}

	private void testInteger10() {
		System.out.println("\n## testInteger10() ##");
		Integer i1 = 10;
		Integer i2 = 10;
		System.out.println("i1 == i2: " + (i1 == i2 ? "true" : "false"));
		System.out.println("i1.equals(i2): "
				+ (i1.equals(i2) ? "true" : "false"));
	}

	private void testInteger140() {
		System.out.println("\n## testInteger140() ##");
		Integer i1 = 140;
		Integer i2 = 140;
		System.out.println("i1 == i2: " + (i1 == i2 ? "true" : "false"));
		System.out.println("i1.equals(i2): "
				+ (i1.equals(i2) ? "true" : "false"));
	}

	private void testString() {
		System.out.println("\n## testString() ##");
		String s1 = "test";
		String s2 = "test";
		System.out.println("s1 == s2: " + (s1 == s2 ? "true" : "false"));
		System.out.println("s1.equals(s2): "
				+ (s1.equals(s2) ? "true" : "false"));
	}
}
