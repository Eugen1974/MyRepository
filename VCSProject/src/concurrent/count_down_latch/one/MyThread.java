package concurrent.count_down_latch.one;

public class MyThread implements Runnable {

	public MyThread(String name) {
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
