package concurrent.summa_of_elements.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		List<MyThread> tasks = Arrays.asList(new MyThread("1-й"), new MyThread("2-й"), new MyThread("3-й"));
		int summa = 0;
		try {
			for (Future<Integer> result : service.invokeAll(tasks)) {
				summa += result.get().intValue();
			}
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		} finally {
			service.shutdown();
		}
		System.out.println("------------");
		System.out.println("summa = " + summa);
	}
}
