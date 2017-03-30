package concurrent.count_down_latch.one;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static final int AMOUNT_THREAD = 10;
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREAD);

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < AMOUNT_THREAD; i++) {
			new MyThread(i + "-й");
		}

		LATCH.await();
		System.out.println("-----");
		System.out.println((System.currentTimeMillis() - startTime) + " milliseconds");
	}
}
