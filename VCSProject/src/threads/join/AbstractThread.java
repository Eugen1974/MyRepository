package threads.join;

public abstract class AbstractThread extends Thread {
	protected int data;
	protected int result;

	public AbstractThread(int data) {
		this.data = data;
	}
}
