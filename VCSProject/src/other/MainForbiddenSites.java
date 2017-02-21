package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MainForbiddenSites {

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<>();
		map.put("mail.ru",  Arrays.asList("http://mail.ru/",   "http://email.ru/", 		"http://mail.rucba/",  "http://mAil1.ruls.com/"));
		map.put("bk.ru",    Arrays.asList("http://bk.ru/",     "http://фисbk.ru/", 	    "http://bk.ru123/",    "http://bK2.ru/"));
		map.put("list.ru",  Arrays.asList("http://list.ru/",   "http://ячсlist.ru/", 	"http://list.ru123/",  "http://lIst3.ru/"));
		map.put("inbox.ru", Arrays.asList("http://inbox.ru/",  "http://йцуinbox.ru/",   "http://inbox.ru456/", "http://iNbox4.ru/"));
		map.put("mail.ua",  Arrays.asList("http://mail.ua/",   "http://ячсmail.ua/", 	"http://mail.ua789/",  "http://mAil5.ua/"));
		map.put("yandex",   Arrays.asList("http://yandex.ua/", "http://проyandex/", 	"http://yandexенг/",   "http://yAnde6x/"));

		map.forEach((key, listValues) -> {
			System.out.printf("%8s: ", key);
			listValues.forEach(value -> {
				System.out.print(Pattern.matches(".+(\\x2e|/)" + key + "(\\x2e|/).*", value.toLowerCase()));
				System.out.print(" ");
			});
			System.out.println();
		});

		System.out.println("\n" + Pattern.matches(".+@mail.ru", "eugen_ua@mail.ru") + "\n");
		
		System.out.println(Pattern.matches(".+", 	 "...A..."));
		System.out.println(Pattern.matches("\\x2e+", "...A..."));
		System.out.println(Pattern.matches("\\x2e+", "......."));
	}
}
//   .    Any character
// \\x2e  hexadecimal code character dot

// X+  X, one or more times
//X*   X, zero or more times
// X|Y Either X or Y
