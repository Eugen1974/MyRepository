package volatile_;

public class MyThread implements Runnable {

	protected static volatile boolean STOPPED = false;

	public MyThread(String name) {
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		while (!STOPPED) {
		}
		System.out.println(Thread.currentThread().getName() + " is stopped");
	}
}
