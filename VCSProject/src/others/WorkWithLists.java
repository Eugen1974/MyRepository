package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class WorkWithLists {

	public static void main(String[] args) {
		arrayOfLists();
		System.out.println();
		listOfLists();
	}

	public static void arrayOfLists() {
		List<?>[] array = new List<?>[3];
		array[0] = new ArrayList<>(Arrays.asList("AAA", "BBB"));
		array[1] = new LinkedList<>(Arrays.asList(111, 222, 333, 444));
		array[2] = new CopyOnWriteArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5));
		System.out.println(
				"\t\t\t\t\t" + array.getClass().getSimpleName() + "\n\t\t\t----------------------------------------");
		for (List<?> list : array) {
			System.out.printf("%41s %17s: ", list.getClass().getName(), list.get(0).getClass().getName());
			list.forEach(item -> System.out.print(item + " "));
			System.out.println();
		}
	}

	public static void listOfLists() {
		List<List<?>> lists = new ArrayList<>();
		lists.add(new LinkedList<String>(Arrays.asList("AAAA", "BBBB")));
		lists.add(Arrays.asList(1111, 2222, 3333));
		lists.add(new CopyOnWriteArrayList<Float>(Arrays.asList(1.11F, 2.22F, 3.33F, 4.44F)));
		lists.add(new Vector<Double>(Arrays.asList(11.1, 22.2, 33.3, 44.4, 55.5)));
		System.out.println(
				"\t\t\t\t\t" + lists.getClass().getSimpleName() + "\n\t\t\t----------------------------------------");
		lists.forEach(list -> {
			System.out.printf("%41s %17s: ", list.getClass().getName(), list.get(0).getClass().getName());
			list.forEach(item -> System.out.print(item + " "));
			System.out.println();
		});
	}
}
