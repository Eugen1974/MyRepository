package threads.switcher;

import java.util.Objects;

public class MyThread implements Runnable {

	private static final Object LOCKER;
	private static final Switcher SWITCHER;
	static {
		SWITCHER = new Switcher(Action.OFF);
		LOCKER = new Object();
	}

	private Action action;

	public MyThread(int orderNum, int num) {
		action = (num % 2 == 0) ? Action.ON : Action.OFF;
		Thread thread = new Thread(this, "N" + orderNum + " " + action.name());
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		synchronized (LOCKER) {
			while (Objects.equals(SWITCHER.state, action)) {
				try {
					LOCKER.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			SWITCHER.state = action;
			System.out.println(Thread.currentThread().getName());
			LOCKER.notifyAll();
		}
	}
}
