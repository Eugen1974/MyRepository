package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainJoin {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final int n = 5;
		Callable<Integer> callable1 = () -> {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
			return 2 * n;
		};
		Callable<Integer> callable2 = () -> {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(2000);
			return n * n;
		};

		System.out.println(Thread.currentThread().getName());
		ExecutorService service = Executors.newCachedThreadPool();
		long startTime = System.currentTimeMillis();
		Future<Integer> future1 = service.submit(callable1);
		Future<Integer> future2 = service.submit(callable2);
		Integer result1 = future1.get();
		Integer result2 = future2.get();
		service.shutdown();

		System.out.println((System.currentTimeMillis() - startTime) + " millisecond");
		System.out.println(result1 + " + " + result2 + " = " + (result1 + result2));
	}
}
