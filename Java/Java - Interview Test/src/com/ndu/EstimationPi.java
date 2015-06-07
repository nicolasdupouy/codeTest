package com.ndu;

public class EstimationPi {

	private static final double RATIO = 3 / 4;

	private static double approx(double[][] pts) {

		double ratioPointsInsideTotal = computeRatioPointsInsideTotal(pts);
		return computeApprox(ratioPointsInsideTotal);
	}

	private static double computeRatioPointsInsideTotal(double[][] pts) {
		double x, y;
		int numberPointsInside = 0;
		int numberPointsTotal = pts.length;

		for (int i = 0; i < numberPointsTotal; i++) {
			x = pts[i][0];
			y = pts[i][1];
			if (isInside(x, y)) {
				numberPointsInside++;
			}
		}
		return numberPointsInside / numberPointsTotal;
	}

	private static boolean isInside(double x, double y) {
		return Math.pow(x, 2) + Math.pow(y, 2) < 1;
	}

	private static double computeApprox(double ratioPointsInsideTotal) {
		return ratioPointsInsideTotal * RATIO;
	}

	public static void main(String[] args) {
		double[][] points = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		double approximation = approx(points);

		System.out.println(approximation);
	}
}
