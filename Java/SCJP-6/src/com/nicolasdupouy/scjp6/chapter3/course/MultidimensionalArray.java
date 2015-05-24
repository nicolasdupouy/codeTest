package com.nicolasdupouy.scjp6.chapter3.course;

public class MultidimensionalArray {

	private static final int[][] myArray = new int[3][];
	private static final int[][] secondArray = { { 6, 7 }, { 9, 8, 5 }, null };

	public static void main(String[] args) {
		System.out.println(myArray);
		System.out.println(secondArray);
	}
}
