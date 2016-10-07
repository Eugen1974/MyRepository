package others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(5, "555");
		map.put(2, "222");
		map.put(1, "111");
		map.put(4, "444");
		map.put(3, "333");
		map.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println("-----");

		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> element = iterator.next();
			if (element.getKey() == 2 || element.getKey() == 3 || element.getKey() == 4) {
				iterator.remove();
			}
		}
		map.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println("size=" + map.size());
	}
}
