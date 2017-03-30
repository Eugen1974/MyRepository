package concurrent.semaphore.one;

import java.util.concurrent.Semaphore;

public class MyThread implements Runnable {

	private Semaphore semaphore;

	public MyThread(Semaphore semaphore, String name) {
		this.semaphore = semaphore;
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			semaphore.acquire();
			System.out.println("Entering " + Thread.currentThread().getName());
			Thread.sleep(500);
			System.out.println("Exiting  " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			semaphore.release();
		}
	}
}
