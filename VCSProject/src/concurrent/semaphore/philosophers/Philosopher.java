package concurrent.semaphore.philosophers;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

	private final int id;
	private final Semaphore semaphore;
	private int numFood;

	public static final int AMOUNT_FOODS = 3;

	public Philosopher(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
		this.numFood = 1;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			while (numFood <= AMOUNT_FOODS) {
				semaphore.acquire();
				System.out.println(id + "-й  сел за стол. Блюдо №" + numFood);
				Thread.sleep(1000);
				System.out.println(id + "-й встал из-за стола. Блюдо №" + numFood);
				Thread.sleep(1000);
				numFood++;
				semaphore.release();
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
