package concurrent.lock_condition;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		new MyThread(3);
//		Thread.sleep(100);

		new MyThread(1);
		new MyThread(2);
		new MyThread(4);
		new MyThread(5);
		new MyThread(6);
		new MyThread(3);
	}
}
