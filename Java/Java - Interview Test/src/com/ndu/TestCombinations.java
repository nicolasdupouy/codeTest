package com.ndu;

import java.math.BigDecimal;

public class TestCombinations {
	/*private static BigInteger factorielle(int n) {
		BigInteger r = BigInteger.ONE;
		for (int k = 2; k <= n; k++) {
			r = r.multiply(BigInteger.valueOf(k));
		}
		return r;
	}

	private static BigInteger produit(int p, int n) {
		if (p == n)
			return BigInteger.valueOf(p);
		else {
			int a = (n + p) / 2;
			return produit(p, a).multiply(produit(a + 1, n));
		}
	}

	private static BigInteger factorielleDichotomie(int n) {
		if (n > 1)
			return produit(2, n);
		else
			return BigInteger.ONE;
	}

	private static BigDecimal factorielleRapide(int n) {
		double d = 0;
		for (int i = 2; i <= n; i++)
			d += Math.log10(i);
		return new BigDecimal(10).pow((int) d);
	}*/

	private static BigDecimal computeCombinations(int n) {
		return new BigDecimal(n).multiply(new BigDecimal(n + 1)).divide(new BigDecimal(2));
	}

	private static BigDecimal count(int n) {
		return computeCombinations(n - 1);
		//return factorielleDichotomie(n - 1);
		//return factorielleRapide(n - 1);
	}

	public static void main(String[] args) {
		displayCountTest(1);
		displayCountTest(4);
		displayCountTest(10000);
	}

	private static void displayCountTest(int n) {
		System.out.println("count(" + n + ") = " + count(n));
	}
}
