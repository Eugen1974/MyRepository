package others;

public class MyThread implements Runnable {

	public MyThread() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			PersonSingleton.getInstance();
			Thread.sleep(1000);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
