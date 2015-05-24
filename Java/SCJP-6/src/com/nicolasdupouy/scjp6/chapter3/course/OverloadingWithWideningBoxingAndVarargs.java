package com.nicolasdupouy.scjp6.chapter3.course;

public class OverloadingWithWideningBoxingAndVarargs {

	public static void main(String[] args) {

		System.out.println("\n## Widening ##");
		Widening widening = new Widening();
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		widening.go(b);
		widening.go(s);
		widening.go(l);
		widening.go(f);

		System.out.println("\n\n## WideningOverBoxing ##");
		WideningOverBoxing wideningOverBoxing = new WideningOverBoxing();
		int i = 5;
		wideningOverBoxing.go(i);

		System.out.println("\n\n## WideningOverVarArgs ##");
		WideningOverVarArgs wideningOverVarArgs = new WideningOverVarArgs();
		wideningOverVarArgs.go(b, b);

		System.out.println("\n\n## BoxingOverVarArgs ##");
		BoxingOverVarArgs boxingOverVarArgs = new BoxingOverVarArgs();
		boxingOverVarArgs.go(b, b);
	}
}

class Widening {
	void go(int x) {
		System.out.print("int ");
	}

	void go(long x) {
		System.out.print("long ");
	}

	void go(double x) {
		System.out.print("double ");
	}
}

class WideningOverBoxing {
	void go(Integer x) {
		System.out.println("Integer");
	}

	void go(long x) {
		System.out.println("WIDENING wins: long");
	}
}

class WideningOverVarArgs {
	void go(int x, int y) {
		System.out.println("WIDENING wins: int,int");
	}

	void go(byte... x) {
		System.out.println("byte... ");
	}
}

class BoxingOverVarArgs {
	void go(Byte x, Byte y) {
		System.out.println("BOXING wins: Byte, Byte");
	}

	void go(byte... x) {
		System.out.println("byte... ");
	}
}
