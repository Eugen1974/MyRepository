package concurrent.switcher;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import threads.switcher.Action;
import threads.switcher.Switcher;

public class MyThread implements Runnable {

	private static final Switcher SWITCHER;
	private static final Lock LOCK;
	private static final Condition CONDITION;
	static {
		SWITCHER = new Switcher(Action.OFF);
		LOCK = new ReentrantLock();
		CONDITION = LOCK.newCondition();
	}

	private Action action;

	public MyThread(int n) {
		action = (n % 2 == 0) ? Action.ON : Action.OFF;
		Thread thread = new Thread(this, action.name());
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		LOCK.lock();
		try {
			while (Objects.equals(SWITCHER.getState(), action)) {
				CONDITION.await();
			}
			SWITCHER.setState(action);
			System.out.println(Thread.currentThread().getName());
			CONDITION.signalAll();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			LOCK.unlock();
		}
	}
}
