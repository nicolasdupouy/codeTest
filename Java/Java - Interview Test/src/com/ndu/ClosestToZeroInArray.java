package com.ndu;

public class ClosestToZeroInArray {
	private static int closetToZero(int[] ints) {
		if (ints == null || ints.length == 0) {
			return 0;
		}

		int closestInt = Integer.MAX_VALUE;
		for (int currentInt : ints) {
			/*if (Math.abs(currentInt) == Integer.MAX_VALUE) {
				continue;
			}*/
			if (Math.abs(currentInt) < Math.abs(closestInt)) {
				closestInt = currentInt;
			}
			else if (Math.abs(currentInt) == Math.abs(closestInt)) {
				closestInt = Math.abs(currentInt);
			}
		}

		return closestInt;
	}

	public static void main(String[] args) {
		int[] arrayIntEmpty = {};
		int[] arrayIntNull = null;
		int[] arrayInt = { -2147483647, -5, -10, 5, 2, -1, 1, 3, 10, 2147483647 };
		System.out.println(closetToZero(arrayIntEmpty));
		System.out.println(closetToZero(arrayIntNull));
		System.out.println(closetToZero(arrayInt));
	}
}
