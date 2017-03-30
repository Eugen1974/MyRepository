package scheduled_threads;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class MainTimerAndTimerTask {

	public static void main(String[] args) throws InterruptedException {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println(LocalTime.now().format(MainScheduledExecutorService.PATTERN) + " "
						+ Thread.currentThread().getName());
			}
		};

		Timer timer = new Timer();
		timer.schedule(timerTask, 0, 1000);

		Thread.sleep(3000);
		timer.cancel();
		timer.purge();
	}
}
