package others;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static final Map<String, Integer> MAP = new HashMap<>();

	public static void main(String[] args) throws IOException {
		initMap();
		sortedByWord();
		sortedByAmount();
	}

	public static void initMap() throws IOException {
		Path path = new File("resources/txt/Шахматисты.txt").toPath();
		List<String> list = Files.readAllLines(path, Charset.forName("UTF-8"));
		for (String line : list) {
			line = line.toLowerCase().replace("ё", "е");
			// delimiter - is not Russian or English characters
			String[] words = line.split("[^а-яА-Яa-zA-Z]");
			for (String word : words) {
				if (word.length() > 0) {
					String key = word.toLowerCase();
					if (MAP.containsKey(key)) {
						Integer value = MAP.get(key);
						MAP.replace(key, ++value);
					} else {
						MAP.put(key, 1);
					}
				}
			}
		}
	}

	public static void sortedByWord() {
		System.out.println("Сортировка по словам");
		System.out.println("--------------------");
		MAP.entrySet().stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
				.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		System.out.println("--------------------");
	}

	public static void sortedByAmount() {
		System.out.println("Сортировка по кол-ву");
		System.out.println("--------------------");
		MAP.entrySet().stream().sorted((o1, o2) -> {
			if (o1.getValue() < o2.getValue())
				return 1;
			if (o1.getValue() > o2.getValue())
				return -1;
			return 0;
		}).forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
	}
}
