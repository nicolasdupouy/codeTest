package com.ndu.java8.defaultMethodsForInterfaces;

public class Main {

	public static void main(String[] args) {
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};

		System.out.println(formula.calculate(100));
		System.out.println(formula.calculate(16));

		// Try with lambda expression (which cannot use the default expression of the interface
		// => Implicitly a functional expression due to his use in this lambda expression.
		/*Formula formula2 = a -> Math.sqrt(a * 100);
		System.out.println(formula2.calculate(100));
		System.out.println(formula2.calculate(16));*/
	}

}
