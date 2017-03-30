package concurrent.lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {

	private int num;

	private static final Lock LOCK = new ReentrantLock();
	private static final Condition CONDITION = LOCK.newCondition();

	public MyThread(int num) {
		this.num = num;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println("Start thread " + num);
		LOCK.lock();
		try {
			while (num != 3) {
				CONDITION.await();
				endRun("await()");
				return;
			}
			endRun("signalAll()");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			LOCK.unlock();
		}
	}

	private void endRun(String str) {
		System.out.println("Thread " + num + " after " + str);
		CONDITION.signalAll();
	}
}