package others;

import java.util.Random;

public class Main {
	private static int[] ARRAY = new int[10];

	public static void main(String[] args) {
		System.out.println("\t\t Simple sort");
		init();
		showArray("Start   ");
		sortSimple(0);
		showArray("Finshed ");

		System.out.println("\n\t\t Bubble sort");
		init();
		showArray("Start   ");
		sortByBubbleMethod(0);
		showArray("Finshed ");
	}

	public static void init() {
		Random random = new Random();
		for (int i = 0; i < ARRAY.length; i++) {
			ARRAY[i] = random.nextInt(100);
		}
	}

	public static void showArray(String text) {
		System.out.print(text);
		for (int i : ARRAY) {
			System.out.print(String.format("%3d", i));
		}
		System.out.println();
	}

	public static void sortSimple(int startPos) {
		if (startPos >= ARRAY.length) {
			return;
		}
		int temp = 0;
		// Purpose that ARRAY[startPos] is minimal element in array
		for (int i = startPos; i < ARRAY.length; i++) {
			if (ARRAY[i] < ARRAY[startPos]) {
				temp = ARRAY[i];
				ARRAY[i] = ARRAY[startPos];
				ARRAY[startPos] = temp;
			}
		}
		sortSimple(++startPos);
	}

	public static void sortByBubbleMethod(int startPos) {
		if (startPos >= ARRAY.length) {
			return;
		}
		int temp;
		boolean exchange = false;
		for (int i = startPos; i < (ARRAY.length - 1); i++) {
			if (ARRAY[i] > ARRAY[i + 1]) {
				temp = ARRAY[i + 1];
				ARRAY[i + 1] = ARRAY[i];
				ARRAY[i] = temp;
				exchange = true;
			}
		}
		if (exchange) {
			sortByBubbleMethod(startPos); // again sorts data within same bounds
		} else {
			sortByBubbleMethod(++startPos);
		}
	}
}
