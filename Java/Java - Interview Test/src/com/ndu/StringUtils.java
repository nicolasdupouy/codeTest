package com.ndu;

public class StringUtils {
	public String concat(String[] strings) {
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		StringUtils stringUtils = new StringUtils();

		String[] stringArray = { "f", "o", "o", "bar" };
		String result = stringUtils.concat(stringArray);
		System.out.println(result);
	}
}
