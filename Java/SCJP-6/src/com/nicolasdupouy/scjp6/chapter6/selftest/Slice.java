package com.nicolasdupouy.scjp6.chapter6.selftest;

import java.text.NumberFormat;

public class Slice {

	public static void main(String[] args) {

		String s = "987,123456";
		double d = 987.123456d;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(d) + " ");
		try {
			System.out.println(nf.parse(s));
		} catch (Exception e) {
			System.out.println("got exc");
		}
	}
}
