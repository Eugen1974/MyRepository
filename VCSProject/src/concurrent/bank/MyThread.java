package concurrent.bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import threads.bank.Account;
import threads.bank.Operation;

public class MyThread implements Runnable {

	private int orderNumOperation;
	private Operation operation;
	private int operationMoney;

	private static final Account ACCOUNT = new Account(0);
	private static final Lock LOCK = new ReentrantLock();
	private static final Condition CONDITION = LOCK.newCondition();

	public MyThread(int orderNumOperation, int typeOperatin, int operationMoney) {
		if (typeOperatin % 2 == 0) {
			operation = Operation.PUT;
		} else {
			operation = Operation.GET;
		}
		this.orderNumOperation = orderNumOperation;
		this.operationMoney = operationMoney;

		Thread thread = new Thread(this, "N" + orderNumOperation + " " + operation.name() + " " + operationMoney);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void run() {
		LOCK.lock();
		try {
			if (operation == Operation.PUT) {
				show();
				ACCOUNT.setMoney(ACCOUNT.getMoney() + operationMoney);
				endRun();
			} // GET
			else {
				while ((ACCOUNT.getMoney() - operationMoney) < 0) {
					CONDITION.await();
				}
				show();
				ACCOUNT.setMoney(ACCOUNT.getMoney() - operationMoney);
				endRun();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			LOCK.unlock();
		}
	}

	private void show() {
		String strOperation;
		if (operation == Operation.PUT) {
			strOperation = "+";
		} else {
			strOperation = "-";
		}
		System.out.printf("N%d %s %3d %s %3d = ", orderNumOperation, operation.name(), ACCOUNT.getMoney(), strOperation,
				operationMoney);
	}

	private void endRun() {
		System.out.printf("%3d\n", ACCOUNT.getMoney());
		CONDITION.signalAll();
	}
}
