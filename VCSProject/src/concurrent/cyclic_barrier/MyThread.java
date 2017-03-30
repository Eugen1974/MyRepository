package concurrent.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

	private CyclicBarrier barrier;
	private String name;

	public MyThread(CyclicBarrier barrier, String name) {
		this.barrier = barrier;
		this.name = name;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " waiting");
			Thread.sleep(500);
			barrier.await();
			System.out.println(name + " working");
			Thread.sleep(500);
			Main.LATCH.countDown();
		} catch (InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
}
