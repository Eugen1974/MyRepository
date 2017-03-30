package concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class MyThread implements Runnable {

	private String data;
	private Exchanger<String> exchanger;

	public MyThread(String data, Exchanger<String> exchanger) {
		this.data = data;
		this.exchanger = exchanger;
	}

	public String getData() {
		return data;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
			data = exchanger.exchange(data);
			Thread.sleep(500);
			Main.LATCH.countDown();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
