package concurrent.switcher;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			new MyThread(random.nextInt(100));
		}
		Thread.sleep(1000);
		System.out.println("----");
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		for (Thread thread : threads) {
			System.out.println(thread.getName());
		}
	}
}
