package concurrent.stack;

import java.util.Objects;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			new MyThread(Integer.valueOf(random.nextInt(100)));
		}
		Thread.sleep(1000);
		System.out.println("----------");
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			String name = threads[i].getName();
			if (!Objects.equals(name, "main")) {
				System.out.println(name);
			}
		}
		System.out.println("LENGTH=" + Data.LENGTH);
	}
}
