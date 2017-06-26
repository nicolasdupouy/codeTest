package com.ndu.java8.dateAPI.localDateTime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Main {

	private static final LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

	public static void main(String[] args) {
		infos();
		convertion();
		//dateFormating();
	}

	private static void infos() {
		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek); // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month); // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay); // 1439
	}

	private static void convertion() {
		Instant instant = sylvester
				.atZone(ZoneId.systemDefault())
				.toInstant();

		Date legacyDate = Date.from(instant);
		System.out.println(legacyDate); // Wed Dec 31 23:59:59 CET 2014
	}

	/*private static void dateFormating() {
		DateTimeFormatter formatter =
				DateTimeFormatter
						.ofPattern("MMM dd, yyyy - HH:mm");

		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string); // Nov 03, 2014 - 07:13
	}*/
}
