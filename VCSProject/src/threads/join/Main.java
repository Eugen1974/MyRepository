package threads.join;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());

		int n = 3;
		Thread1 thread1 = new Thread1(n);
		Thread2 thread2 = new Thread2(n);

		long startTime = System.currentTimeMillis();

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println((System.currentTimeMillis() - startTime) + " millisecond");
		System.out.println(thread1.result + " + " + thread2.result + " = " + (thread1.result + thread2.result));
	}
}
