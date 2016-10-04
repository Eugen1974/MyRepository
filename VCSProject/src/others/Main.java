package others;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		My[] array = new My[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = new My(i);
		}

		array = null;
		System.gc(); // ask garbage collector start to work

		Thread.sleep(1000); // pause to garbage collector can work
	}
}
