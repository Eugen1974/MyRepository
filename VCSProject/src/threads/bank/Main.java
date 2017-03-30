package threads.bank;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			new MyThread(i, random.nextInt(100), random.nextInt(100));
		}
		Thread.sleep(1000);
		System.out.println("----------------------");
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			System.out.println(threads[i].getName());
		}
	}
}
