package concurrent.stop_all_threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyThread implements Runnable {

	public static final AtomicBoolean STOPPED = new AtomicBoolean(false);

	@Override
	public void run() {
		while (!STOPPED.get()) {
		}
		System.out.println(Thread.currentThread().getName());
		Main.END_SIGNAL.countDown();
	}
}
