package concurrent.semaphore.philosophers;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(2);
		for (int i = 1; i <= 5; i++) {
			new Philosopher(i, semaphore);
			Thread.sleep(1000);
		}
	}
}
