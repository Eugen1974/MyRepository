package others;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>("aa", "bb", "cc");

		System.out.println(list + "\n");
		list.forEach(s -> System.out.print(s + " "));
		System.out.println("\n");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
			list.remove();
			System.out.println(" " + list);
		}
		System.out.println("---------\nsize=" + list.size());

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		System.out.println("\n" + list + " size=" + list.size());
		list.forEach(i -> System.out.print(i + " "));
	}
}
