package concurrent.summa_of_elements.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<Integer> {

	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public Integer call() throws InterruptedException {
		Thread.sleep(500);
		int num = ThreadLocalRandom.current().nextInt(15);
		System.out.println(name + " added " + num);
		Thread.sleep(500);
		return num;
	}
}
