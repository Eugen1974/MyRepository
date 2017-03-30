package concurrent.summa_of_elements.count_down_latch;

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
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
