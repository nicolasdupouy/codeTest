package com.nicolasdupouy.scjp6.chapter6.selftest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFor {

	public static void main(String[] args) {

		String s;
		try {
			FileReader fr = new FileReader("myfile.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null)
				System.out.println(s);
			// br.flush();
		} catch (IOException e) {
			System.out.println("io error");
		}
	}
}
