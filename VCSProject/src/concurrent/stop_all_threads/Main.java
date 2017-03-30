package concurrent.stop_all_threads;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static final int AMOUNT_THREADS = 10;
	public static final CountDownLatch END_SIGNAL = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new Thread(new MyThread(), String.valueOf(i) + "-й").start();
		}
		Thread.sleep(1000);
		MyThread.STOPPED.set(true);
		END_SIGNAL.await();
		System.out.println("----");
		System.out.println((System.currentTimeMillis() - startTime) + " millisecond");
	}
}
