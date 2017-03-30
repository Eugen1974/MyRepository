package concurrent.id_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread2 implements Runnable {

	private int idThread;

	private static int ID;
	private static final Lock LOCK = new ReentrantLock();

	public MyThread2() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);

			LOCK.lock();
			idThread = ID++;
			LOCK.unlock();

			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + " " + idThread);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
