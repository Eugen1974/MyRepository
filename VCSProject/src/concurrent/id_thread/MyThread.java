package concurrent.id_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable {

	private int idThread;

	private static final AtomicInteger ID = new AtomicInteger(0);

	public MyThread() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);

			idThread = ID.getAndIncrement();

			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + " " + idThread);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
