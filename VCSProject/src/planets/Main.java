package planets;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println(Planets.class.getName() + "\n---------------");
		for (Planets p : Planets.values()) {
			System.out.println(p);
		}
		System.out.println("\n" + Planets.MARS);

		Set<Planets> set = EnumSet.range(Planets.MOON, Planets.VENERA);
		System.out.println("\n" + set.getClass().getName() + "\n------------------------");
		set.forEach(System.out::println);

		Map<Planets, String> map = new EnumMap<>(Planets.class);
		map.put(Planets.VENERA, "Venera");
		map.put(Planets.EARTH, "Earth");
		System.out.println("\n" + map.getClass().getName() + "\n-----------------");
		map.forEach((key, value) -> System.out.printf("%11s%s\n", "key=[" + key.getRuName(), "]  value=" + value));
	}
}
