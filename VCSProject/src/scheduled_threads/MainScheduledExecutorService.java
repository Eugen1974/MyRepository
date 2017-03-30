package scheduled_threads;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainScheduledExecutorService {

	public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static void main(String[] args) throws InterruptedException {
		Runnable run = () -> {
			System.out.println(LocalTime.now().format(PATTERN) + " " + Thread.currentThread().getName());
		};

		ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
	 // ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		service.scheduleWithFixedDelay(run, 0, 1, TimeUnit.SECONDS);

		Thread.sleep(5000);
		service.shutdown();
	}
}
