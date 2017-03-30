package concurrent.semaphore.one;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 10; i++) {
			new MyThread(semaphore, i + "-й");
			Thread.sleep(100);
		}
	}
}
