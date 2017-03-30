package concurrent.count_down_latch.two;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static final int AMOUNT_THREADS = 3;
	public static final CountDownLatch START_SIGNAL = new CountDownLatch(1);
	public static final CountDownLatch END_SIGNAL = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new Thread(new MyThread()).start();
		}

		Thread.sleep(1000);
		START_SIGNAL.countDown();
		END_SIGNAL.await();
		System.out.println("----------------");
		System.out.println((System.currentTimeMillis() - startTime) + " millisecond");
	}
}
