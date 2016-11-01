package others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		doSet(new HashSet<>());
		doSet(new LinkedHashSet<>());
		doSet(new TreeSet<>());

		doMap(new HashMap<>());
		doMap(new LinkedHashMap<>());
		doMap(new TreeMap<>());
	}

	public static void doSet(Set<String> set) {
		set.add("222");
		set.add("333");
		set.add("111");

		System.out.println("\n" + set.getClass().getSimpleName() + "\n-------------");
		set.forEach(System.out::println);
	}

	public static void doMap(Map<Integer, String> map) {
		map.put(2, "222");
		map.put(3, "333");
		map.put(1, "111");

		System.out.println("\n" + map.getClass().getSimpleName() + "\n-------------");
		map.forEach((key, value) -> System.out.println(key + " " + value));
	}
}
