package others;

public class Main1 {
//	public static final int[] ARRAY = new int[] { 0, 1, 2, 3, 5, 6, 7, 0, 0, 0 }; // 10
	public static final int[] ARRAY = new int[10];
	public static int SIZE = 0;

	public static void main(String[] args) {
		show();
		insert(2);
		insert(5);
		insert(3);
		insert(1);
		insert(5);
		show();
	}

	private static boolean insert(int n) {
		if (SIZE == ARRAY.length) {
			return false;
		}
		for (int i = 0; i < SIZE; i++) {
			if (ARRAY[i] > n) {
				for (int j = SIZE; j > i; j--) { // go from back to forward, offset rest elements to right
					ARRAY[j] = ARRAY[j - 1];
				}
				ARRAY[i] = n;
				SIZE++;
				return true;
			}
		}
		ARRAY[SIZE] = n; // n >= max element - it will be last
		SIZE++;
		return true;
	}

	public static void show() {
		for (int i = 0; i < ARRAY.length; i++) {
			System.out.print(String.format("%2d", ARRAY[i]) + " ");
		}
		System.out.println();
	}
}
