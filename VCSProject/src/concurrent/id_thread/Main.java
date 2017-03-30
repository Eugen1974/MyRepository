package concurrent.id_thread;

import java.util.concurrent.CountDownLatch;

public class Main {

	public static final int AMOUNT_THREAD = 10;
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREAD);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < AMOUNT_THREAD; i++) {
			new MyThread();
		}
		LATCH.await();
	}
}
