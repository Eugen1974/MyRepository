package concurrent.id_thread;

public class MyThread3 implements Runnable {

	private int idThread;

	private static int ID;
	private static final Object LOCK = new Object();

	public MyThread3() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);

			synchronized (LOCK) {
				idThread = ID++;
			}

			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + " " + idThread);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
