package others;

import java.util.Random;

public class Main {
	public static final int AMOUNT_ELEMENTS = 10;
	public static final int[] ARRAY = new int[AMOUNT_ELEMENTS];

	public static void main(String[] args) {
		init();
		show();
		sort();
		show();
		System.out.println();
		for (int i = 0; i < AMOUNT_ELEMENTS; i++) {
			System.out.println(String.format("%2d", ARRAY[i]) + " index=" + search(ARRAY[i]));
		}
		System.out.println("\n" + search(-1) + " " + search(12) + " " + search(100));
	}

	public static void init() {
		Random random = new Random();
		for (int i = 0; i < AMOUNT_ELEMENTS; i++) {
			ARRAY[i] = random.nextInt(100);
		}
	}

	public static void show() {
		for (int i = 0; i < AMOUNT_ELEMENTS; i++) {
			System.out.print(String.format("%2d", ARRAY[i]) + " ");
		}
		System.out.println();
	}

	public static void sort() {
		sort(0); // sorting all array
	}

	public static void sort(int start) {
		if ((start + 1) == AMOUNT_ELEMENTS) {
			return;
		}
		int temp;
		for (int i = start; i < AMOUNT_ELEMENTS; i++) {
			if (ARRAY[start] > ARRAY[i]) {
				temp = ARRAY[i];
				ARRAY[i] = ARRAY[start];
				ARRAY[start] = temp;
			}
		}
		sort(++start);
	}

	public static int search(int searchNum) {
		return search(searchNum, 0, (AMOUNT_ELEMENTS - 1)); // searching over
															// whole array
	}

	public static int search(int searchNum, int left, int right) {
		if (searchNum == ARRAY[left]) {
			return left;
		} else if (searchNum == ARRAY[right]) {
			return right;
		}
		int middle = left + (right - left) / 2;
		if (left == middle || middle == right) {
			return -1; // nothing
		}
		if (searchNum > ARRAY[left] && searchNum < ARRAY[right]) {
			int result = search(searchNum, left, middle);
			if (result == -1) {
				result = search(searchNum, middle, right);
			}
			return result;
		}
		return -1; // nothing
	}
}
