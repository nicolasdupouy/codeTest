package com.nicolasdupouy.scjp6.chapter4.selftest;

public class Comparison {
	public static void main(String[] args) {
		float f1 = 2.3f;
		float[][] f2 = { { 42.0f }, { 1.7f, 2.3f }, { 2.6f, 2.7f } };
		float[] f3 = { 2.7f };
		Long x = 42L;
		// insert code here
		/*
		 * if(f1 == f2) System.out.println("F1");
		 */
		if (f1 == f2[2][1])
			System.out.println("F2");
		if (x == f2[0][0])
			System.out.println("F3");
		/*
		 * if(f1 == f2[1,1]) System.out.println("F4");
		 */
		if (f3 == f2[2])
			System.out.println("F5");
	}
}
