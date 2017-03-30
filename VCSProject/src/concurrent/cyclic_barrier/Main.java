package concurrent.cyclic_barrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {

	public static final int AMOUNT_THREADS = 3;
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(AMOUNT_THREADS, () -> {
			System.out.println("\nStart over barrier");
			System.out.println("------------------");
		});

		new MyThread(barrier, "1-й");
		new MyThread(barrier, "2-й");
		new MyThread(barrier, "3-й");

		LATCH.await();
		System.out.println();

		new MyThread(barrier, "4-й");
		new MyThread(barrier, "5-й");
		new MyThread(barrier, "6-й");
	}
}
