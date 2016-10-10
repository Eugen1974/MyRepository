package time;

import others.ArrayList;

public class TimeArrayListTest {

	public static final int AMOUNT_ELEMNTS = 1_000_000;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		long startTime = System.nanoTime();
		for (int i = 0; i < AMOUNT_ELEMNTS; i++) {
			list.add(i);
		}
		System.out.println(String.format("%.2f", (double) (System.nanoTime() - startTime) / 1E9) + " c.");

		System.out.println("\nlength=" + list.getArrayLength() + "\n  size=" + list.getSize() + "\n delta="
				+ (list.getArrayLength() - list.getSize()));

		list.trimToSize();
		
		System.out.println("\nlength=" + list.getArrayLength() + "\n  size=" + list.getSize() + "\n delta="
				+ (list.getArrayLength() - list.getSize()));
	}
}
// 100_000_000 elements java.lang.OutOfMemoryError: Java heap space