package volatile_;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			new MyThread(String.valueOf(i));
		}
		Thread.sleep(1000);
		MyThread.STOPPED = true;
		Thread.sleep(10);
		System.out.println("------------");
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			System.out.println(threads[i].getName());
		}
	}
}
