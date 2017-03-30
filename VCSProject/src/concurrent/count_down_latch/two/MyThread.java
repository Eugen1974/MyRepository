package concurrent.count_down_latch.two;

public class MyThread implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Waiting for start signal " + Thread.currentThread().getName());
			Main.START_SIGNAL.await();
			System.out.println("Working " + Thread.currentThread().getName());
			Thread.sleep(1000);
			Main.END_SIGNAL.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
