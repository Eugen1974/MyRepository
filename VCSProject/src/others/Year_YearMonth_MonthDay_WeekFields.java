package others;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

public class Year_YearMonth_MonthDay_WeekFields {

	public static void main(String[] args) {
		final DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("yyyy");
		final DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		final DateTimeFormatter pattern3 = DateTimeFormatter.ofPattern("MM.yyyy");

		LocalDate d1 = Year.parse("2011", pattern1).atMonthDay(MonthDay.of(Month.FEBRUARY, 15));
		System.out.println(d1.format(pattern2));

		LocalDate d2 = YearMonth.parse("07.2012", pattern3).atDay(10);
		System.out.println(d2.format(pattern2));

		LocalDate d3 = MonthDay.of(Month.AUGUST, 18).atYear(2015);
		System.out.println(d3.format(pattern2));

		WeekFields weekFields = WeekFields.of(DayOfWeek.SATURDAY, 6);
		System.out.println("\n" + weekFields + "\n");
		System.out.printf("%28s%8s\n%28s%1d\n%28s%s\n", "getFirstDayOfWeek()=", weekFields.getFirstDayOfWeek(),
				"getMinimalDaysInFirstWeek()=", weekFields.getMinimalDaysInFirstWeek(), "weekBasedYear()=",
				weekFields.weekBasedYear());
	}
}
