package com.nicolasdupouy.scjp6.chapter6.selftest;

import java.io.Console;

public class TalkerConsole {

	public static void main(String[] args) {

		Console c = System.console();
		String u = c.readLine("%s", "username: ");
		System.out.println("hello " + u);

		// String pw;
		char[] pw;
		if (c != null && (pw = c.readPassword("%s", "password: ")) != null) {
			// check for valid password
		}
	}
}