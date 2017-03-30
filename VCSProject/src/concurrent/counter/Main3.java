package concurrent.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {

	private static AtomicInteger COUNTER = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		Runnable run = () -> {
			try {
				Thread.sleep(100);
				for (int i = 0; i < 100; i++) {
					COUNTER.incrementAndGet();
				}
				Main1.LATCH.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};

		for (int i = 0; i < Main1.AMOUNT_THREADS; i++) {
			new Thread(run).start();
		}

		Main1.LATCH.await();
		System.out.println("COUNTER=" + COUNTER);
	}
}
