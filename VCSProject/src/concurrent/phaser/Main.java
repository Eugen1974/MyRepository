package concurrent.phaser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

public class Main {

	public static final int AMOUNT_THREADS = 4;
	public static final CountDownLatch LATCH_PHASE_START  = new CountDownLatch(AMOUNT_THREADS);
	public static final CountDownLatch LATCH_PHASE_1 	  = new CountDownLatch(AMOUNT_THREADS);
	public static final CountDownLatch LATCH_PHASE_2 	  = new CountDownLatch(AMOUNT_THREADS);
	public static final CountDownLatch LATCH_PHASE_FINISH = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser = new Phaser();

		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new MyThread(phaser, i + "-й");
		}

		endPhase(LATCH_PHASE_START, 0);
		endPhase(LATCH_PHASE_1, 1);
		endPhase(LATCH_PHASE_2, 2);

		LATCH_PHASE_FINISH.await();

		System.out.println("\narrivedParties   =" + phaser.getArrivedParties());
		System.out.println("unarrivedParties =" + phaser.getUnarrivedParties());
		System.out.println("registeredParties=" + phaser.getRegisteredParties());
	}

	private static void endPhase(CountDownLatch latch, int numPhase) throws InterruptedException {
		latch.await();
		System.out.println("-------------------");
		System.out.println("End of phase " + numPhase + "\n");
	}
}
