package others;

import java.util.Random;

public class Main {
	private static int[] ARRAY = new int[10];

	public static void main(String[] args) {
		init();
		show();
		sort();
		show();
		for (int i = 0; i < ARRAY.length; i++) {
			System.out.println(String.format("%3d", ARRAY[i]) + " index = " + search(ARRAY[i]));
		}
		System.out.println();
		int[] absentNums = new int[] { -1, 70, 100 };
		for (int i = 0; i < absentNums.length; i++) {
			System.out.println(String.format("%3d", absentNums[i]) + " index = " + search(absentNums[i]));
		}
	}

	public static void init() {
		Random random = new Random();
		for (int i = 0; i < ARRAY.length; i++) {
			ARRAY[i] = random.nextInt(100);
		}
	}

	public static void show() {
		for (int i = 0; i < ARRAY.length; i++) {
			System.out.print(String.format("%3d", ARRAY[i]));
		}
		System.out.println("\n");
	}

	public static void sort() {
		sort(0);
	}

	public static void sort(int startPos) {
		if (startPos >= ARRAY.length) {
			return;
		}
		int temp;
		for (int i = startPos; i < ARRAY.length; i++) {
			if (ARRAY[startPos] > ARRAY[i]) {
				temp = ARRAY[i];
				ARRAY[i] = ARRAY[startPos];
				ARRAY[startPos] = temp;
			}
		}
		// --------------
		sort(++startPos); // recursive call
		// --------------
	}

	public static int search(final int searchNum) {
		return search(searchNum, 0, ARRAY.length - 1);
	}

	public static int search(final int searchNum, int startPos, int endPos) {
		if (searchNum == ARRAY[startPos]) {
			return startPos;
		} else if (searchNum == ARRAY[endPos]) {
			return endPos;
		}

		int middlePos = startPos + (endPos - startPos) / 2;
		if (startPos == middlePos || middlePos == endPos) {
			return -1; // nothing
		}

		int result = -1; // nothing
		if (searchNum > ARRAY[startPos] && searchNum <= ARRAY[middlePos]) {
			// ---------------------------------------------
			result = search(searchNum, startPos, middlePos); // recursive call
			// ---------------------------------------------
		} else if (searchNum >= ARRAY[middlePos] && searchNum < ARRAY[endPos]) {
			// -------------------------------------------
			result = search(searchNum, middlePos, endPos); // recursive call
			// -------------------------------------------
		}
		return result;
	}
}
