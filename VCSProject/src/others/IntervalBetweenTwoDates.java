package others;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class IntervalBetweenTwoDates {

	public static void main(String[] args) {
		final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

		final LocalDateTime startDate = LocalDateTime.parse("20.08.2017 11:12:33", pattern);
		final LocalDateTime endDate = LocalDateTime.now();

		long intervalDays = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("intervalDays=" + intervalDays);

		long intervalHours = ChronoUnit.HOURS.between(startDate, endDate);
		System.out.println("intervalHours=" + intervalHours);

		long intervalSeconds = ChronoUnit.SECONDS.between(startDate, endDate);
		System.out.println("intervalSeconds=" + intervalSeconds + "\n");

		double interval = ((double) intervalSeconds) / (24 * 60 * 60);
		System.out.printf("%s%.2f\n", "intervalDays=", interval);

		BigDecimal bigDecimal = BigDecimal.valueOf(interval).setScale(2, RoundingMode.HALF_UP);
		System.out.println("intervalDays=" + bigDecimal);
	}
}
