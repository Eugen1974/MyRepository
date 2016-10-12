package others;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExamples {

	public static void main(String[] args) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d MMMM yyyy EEEE");
		LocalDate now = LocalDate.now();

		LocalDate date = now.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
		System.out.println("2th Tuesday current month = " + date.format(pattern) + "\n");

		date = now.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("1th day next month = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("1th day next month = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println("1th day next year = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.firstDayOfYear());
		System.out.println("1th day current year = " + date.format(pattern) + "\n");

		date = now.plusMonths(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));
		System.out.println("1th Friday in next month = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("last day of current month = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("last day of current year = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
		System.out.println("last Thursday in current month = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println("next Wednesday = " + date.format(pattern) + "\n");

		DayOfWeek dayOfWeekNow = now.getDayOfWeek();
		date = now.with(TemporalAdjusters.nextOrSame(dayOfWeekNow));
		System.out.println(
				"next or same " + dayOfWeekNow.name() + " = " + date.format(pattern) + " (this's current day)\n");

		date = now.with(TemporalAdjusters.ofDateAdjuster(d -> d.minusMonths(1).plusDays(1)));
		System.out.println(
				"date adjuster = " + date.format(pattern) + " (some operations with date: -1 month + 1 day)\n");

		date = now.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY));
		System.out.println("previous Wednesday = " + date.format(pattern) + "\n");

		date = now.with(TemporalAdjusters.previousOrSame(dayOfWeekNow));
		System.out.println(
				"previous or same " + dayOfWeekNow.name() + " = " + date.format(pattern) + " (this's current day)");
	}
}
