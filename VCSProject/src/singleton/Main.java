package singleton;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static final int AMOUNT_THREADS = 100;
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new MyThread();
		}
		LATCH.await();
		System.out.println("-----------------------");
		System.out.println(Singleton.getInstance());
	}
}
