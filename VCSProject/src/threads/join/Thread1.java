package threads.join;

public class Thread1 extends AbstractThread {

	public Thread1(int data) {
		super(data);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			result = 2 * data;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
