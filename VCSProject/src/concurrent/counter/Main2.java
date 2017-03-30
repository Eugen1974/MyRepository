package concurrent.counter;

public class Main2 {

	private static final Object LOCK = new Object();
	private static int COUNTER;

	public static void main(String[] args) throws InterruptedException {
		Runnable run = () -> {
			try {
				Thread.sleep(100);
				synchronized (LOCK) {
					for (int i = 0; i < 100; i++) {
						COUNTER++;
					}
				}
				Main1.LATCH.countDown();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};

		for (int i = 0; i < Main1.AMOUNT_THREADS; i++) {
			new Thread(run).start();
		}

		Main1.LATCH.await();
		System.out.println("COUNTER=" + COUNTER);
	}
}
