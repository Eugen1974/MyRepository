package concurrent.counter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main1 {

	private static int COUNTER = 0;

	public static final int AMOUNT_THREADS = 10_000;
	public static final Lock LOCK = new ReentrantLock();
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		Runnable run = () -> {
			try {
				Thread.sleep(100);

				LOCK.lock();
				for (int i = 0; i < 100; i++) {
					COUNTER++;
				}
				LOCK.unlock();

				LATCH.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};

		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new Thread(run).start();
		}

		LATCH.await();
		System.out.println("COUNTER=" + COUNTER);
	}
}
