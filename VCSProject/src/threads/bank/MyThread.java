package threads.bank;

public class MyThread implements Runnable {

	private int orderNumOperation;
	private Operation operation;
	private int operationMoney;

	private static final Account ACCOUNT = new Account(0);
	private static final Object LOCK = new Object();

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
		synchronized (LOCK) {
			if (operation == Operation.PUT) {
				show();
				ACCOUNT.setMoney(ACCOUNT.getMoney() + operationMoney);
				endRun();
			} // GET
			else {
				while ((ACCOUNT.getMoney() - operationMoney) < 0) {
					try {
						LOCK.wait();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				show();
				ACCOUNT.setMoney(ACCOUNT.getMoney() - operationMoney);
				endRun();
			}
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
		LOCK.notifyAll();
	}
}
