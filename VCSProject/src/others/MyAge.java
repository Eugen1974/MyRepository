package others;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class MyAge {
	
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(1974, Month.FEBRUARY, 15);
		LocalDate now = LocalDate.now();

		long fullAmountYears = ChronoUnit.YEARS.between(start, now);
		LocalDate startPlusFullAmountYears = start.plusYears(fullAmountYears);

		long restDays = ChronoUnit.DAYS.between(startPlusFullAmountYears, now);
		float floatPartYear = (float) restDays / now.lengthOfYear();
		System.out.println(String.format("%s %.1f %s", "Мне", (float) fullAmountYears + floatPartYear, "года/год/лет"));
	}
}
