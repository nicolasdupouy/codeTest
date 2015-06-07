package com.ndu;

import java.util.Arrays;

public class Tests {

	private static boolean exists(int[] ints, int k) {
		//Arrays.sort(ints);
		if (Arrays.binarySearch(ints, k) >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] ints = { -9, 14, 37, 102 };
		System.out.println(exists(ints, 102));
		System.out.println(exists(ints, 36));
	}
}
