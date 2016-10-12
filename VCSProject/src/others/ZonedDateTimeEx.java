package others;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeEx {

	public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm a z O");

	public static void main(String[] args) {
		ZonedDateTime zonedTime = LocalDateTime.now().atZone(ZoneId.systemDefault());

		ZonedDateTime zone1 = zonedTime.withZoneSameInstant(ZoneId.of("Europe/Kiev"));
		ZonedDateTime zone2 = zonedTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
		ZonedDateTime zone3 = zonedTime.withZoneSameInstant(ZoneId.of("Asia/Kamchatka"));

		System.out.println(zone1.format(PATTERN) + " " + zone1.getZone() + " " + zone1.getOffset());
		System.out.println(zone2.format(PATTERN) + " " + zone2.getZone() + " " + zone2.getOffset());
		System.out.println(zone3.format(PATTERN) + " " + zone3.getZone() + " " + zone3.getOffset());

		System.out.println("\nDefault ZoneId=" + ZoneId.systemDefault() + "\n");

		System.out.println(zone2 + "\n" + zone2.toLocalDateTime());
	}
}