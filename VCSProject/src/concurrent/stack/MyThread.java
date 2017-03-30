package concurrent.stack;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import threads.bank.Operation;

public class MyThread implements Runnable {

	private static final Data<Integer> DATA;
	private static final Lock LOCK;
	private static final Condition CONDITION;
	static {
		DATA = new Data<>();
		LOCK = new ReentrantLock();
		CONDITION = LOCK.newCondition();
	}

	private Operation operation;
	private Integer data;

	public MyThread(Integer data) {
		this.operation = (data % 2 == 0) ? Operation.PUT : Operation.GET;
		this.data = data;
		Thread thread = new Thread(this, operation.name());
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		LOCK.lock();
		try {
			if (Objects.equals(operation, Operation.PUT)) {
				while (DATA.getSize() == Data.LENGTH) {
					CONDITION.await();
				}
				DATA.put(data);
				endOfRun();
			} else { // GET
				while (DATA.getSize() == 0) {
					CONDITION.await();
				}
				DATA.get();
				endOfRun();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			LOCK.unlock();
		}
	}

	public void endOfRun() {
		System.out.println(operation + " size=" + DATA.getSize());
		CONDITION.signalAll();
	}
}
