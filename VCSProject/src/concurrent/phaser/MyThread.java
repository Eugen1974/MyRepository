package concurrent.phaser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

public class MyThread implements Runnable {

	private Phaser phaser;
	private String name;

	public MyThread(Phaser phaser, String name) {
		this.phaser = phaser;
		this.name = name;
		this.phaser.register();
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			doPhase(Main.LATCH_PHASE_START);
			doPhase(Main.LATCH_PHASE_1);
			doPhase(Main.LATCH_PHASE_2);

			phaser.arriveAndDeregister();
			Thread.sleep(1000);
			System.out.println(name + " поток достиг точки синхронизации и снимается с участия");
			Main.LATCH_PHASE_FINISH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private void doPhase(CountDownLatch latch) throws InterruptedException {
		int numPhase = phaser.getPhase();
		Thread.sleep(1000);
		System.out.println(name + " waiting phase " + numPhase);
		phaser.arriveAndAwaitAdvance();
		Thread.sleep(1000);
		System.out.println(name + " working phase " + numPhase);
		latch.countDown();
	}
}
