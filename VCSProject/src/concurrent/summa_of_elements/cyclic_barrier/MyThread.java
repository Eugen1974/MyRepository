package concurrent.summa_of_elements.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Runnable {

	public MyThread(String name) {
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			int num = ThreadLocalRandom.current().nextInt(15);
			Main.LIST.add(num);
			System.out.println(Thread.currentThread().getName() + " added " + num);
			Thread.sleep(500);
			Main.BARRIER.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
}
