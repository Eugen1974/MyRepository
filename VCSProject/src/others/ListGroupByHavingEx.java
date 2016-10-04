package others;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListGroupByHavingEx {
	public static void main(String[] args) {
		List<Character> list = Arrays.asList('C', 'B', 'A', 'F', 'E', 'D', 'B', 'A', 'C', 'C', 'A', 'C', 'C');

		Map<Character, List<Character>> map = list.stream().collect(Collectors.groupingBy(c -> c));
		map.forEach((key, value) -> System.out.println(key + " " + value));

		System.out.println();

		Map<Character, Long> map1 = list.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		map1.forEach((key, value) -> System.out.println(key + " " + value));

		Iterator<Map.Entry<Character, Long>> iterator = map1.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue() == 1) {
				iterator.remove();
			}
		}

		System.out.println("\nDuplicate values");
		map1.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println("size=" + map1.size());
	}
}