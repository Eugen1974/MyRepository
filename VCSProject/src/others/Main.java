package others;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<MyEnum> set = EnumSet.allOf(MyEnum.class);
		System.out.println(set.getClass().getName() + "\n------------------------");
		System.out.println(set + "\n");

		f(new EnumMap<>(MyEnum.class));
		f(new LinkedHashMap<>());
		f(new HashMap<>());
	}

	public static void f(Map<MyEnum, String> map) {
		map.put(MyEnum.CCC, "ccc");
		map.put(MyEnum.BBB, "bbb");
		map.put(MyEnum.AAA, "aaa");
		map.put(MyEnum.CCC, "ccccc");
		System.out.println(map.getClass().getName() + "\n-----------------------");
		map.forEach((key, value) -> System.out.printf("%3s %5s\n", key, value));
		System.out.println();
	}
}