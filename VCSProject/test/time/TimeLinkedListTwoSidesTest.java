package time;

import others.LinkedListTwoSides;

public class TimeLinkedListTwoSidesTest {
	public static void main(String[] args) {
		LinkedListTwoSides<Integer> list = new LinkedListTwoSides<>();

		long startTime = System.nanoTime();
		for (int i = 0; i < TimeArrayListTest.AMOUNT_ELEMNTS; i++) {
			list.add(i);
		}
		System.out.println(String.format("%.2f", (double) (System.nanoTime() - startTime) / 1E9) + " c.");
	}
}
// 10_000_000 elements java.lang.OutOfMemoryError: Java heap space