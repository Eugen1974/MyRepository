package concurrent.exchanger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class Main {

	public static final CountDownLatch LATCH = new CountDownLatch(4);

	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> exchanger = new Exchanger<>();

		MyThread t1 = new MyThread("1", exchanger);
		MyThread t2 = new MyThread("2", exchanger);
		MyThread t3 = new MyThread("3", exchanger);
		MyThread t4 = new MyThread("4", exchanger);

		System.out.println(t1.getData() + " " + t2.getData() + " " + t3.getData() + " " + t4.getData());

		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();

		LATCH.await();

		System.out.println(t1.getData() + " " + t2.getData() + " " + t3.getData() + " " + t4.getData());
	}
}
