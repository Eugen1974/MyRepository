package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorCompletionService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		ExecutorCompletionService<String> service = new ExecutorCompletionService<>(threadPool);

		long startTime = System.currentTimeMillis();
		service.submit(() -> {
			Thread.sleep(3000);
			return "AAA " + Thread.currentThread().getName();
		});

		service.submit(() -> {
			Thread.sleep(2000);
			return "BBB " + Thread.currentThread().getName();
		});

		service.submit(() -> {
			Thread.sleep(1000);
			return "CCC " + Thread.currentThread().getName();
		});

		System.out.println(service.take().get());
		System.out.println(service.take().get());
		System.out.println(service.take().get());

		threadPool.shutdown();
		System.out.println("\n" + (System.currentTimeMillis() - startTime) + " millisecond");
	}
}
