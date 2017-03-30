package concurrent;

import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {

	private static final int AMOUNT_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {
		System.out.printf("%22s %d\n", "availableProcessors = ", Runtime.getRuntime().availableProcessors());
		System.out.printf("%22s %9d %s\n", "maxMemory = ", Runtime.getRuntime().maxMemory(), " bytes");
		System.out.printf("%22s %9d %s\n", "totalMemory = ", Runtime.getRuntime().totalMemory(), " bytes");
		System.out.printf("%22s %9d %s\n\n", "freeMemory = ", Runtime.getRuntime().freeMemory(), " bytes");

		CountDownLatch countDownLatch = new CountDownLatch(AMOUNT_THREADS);
		Runnable run = () -> {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new Thread(run, String.valueOf(i) + "-й").start();
		}

		countDownLatch.await(); // wait for finishing threads' work
		System.out.println("----");
		System.out.println((System.currentTimeMillis() - startTime) + " millisecond");
	}
}
