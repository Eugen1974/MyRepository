package threads.join;

public class Thread2 extends AbstractThread {

	public Thread2(int data) {
		super(data);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			result = data * data;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
