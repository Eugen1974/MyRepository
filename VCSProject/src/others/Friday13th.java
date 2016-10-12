package others;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Friday13th {
	
	public static void main(String[] args) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate start = LocalDate.parse("01.01.2010", pattern);
		LocalDate end = LocalDate.now();

		for (LocalDate d = start; d.isBefore(end); d = d.plusMonths(1)) {
			LocalDate temp = LocalDate.of(d.getYear(), d.getMonthValue(), 13);
			if (temp.getDayOfWeek() == DayOfWeek.FRIDAY) {
				System.out.println(temp.format(pattern));
			}
		}

		System.out.println("----------------");
		System.out.println("start=" + start.format(pattern) + "\n  end=" + end.format(pattern));
	}
}
