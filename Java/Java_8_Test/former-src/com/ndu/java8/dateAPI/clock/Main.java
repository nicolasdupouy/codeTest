package com.ndu.java8.dateAPI.clock;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant); // legacy java.util.Date

	}

}
