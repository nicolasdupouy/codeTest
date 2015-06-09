package com.nicolasdupouy.scjp6.chapter6.selftest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		while (m.find()) {
			System.out.println(m.start() + m.group());
		}
	}
}

// Parameters: "\d*" ab34ef
