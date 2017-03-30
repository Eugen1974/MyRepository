package concurrent.summa_of_elements.count_down_latch;

import java.util.IntSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Main {

	public static final int AMOUNT_THREADS = 3;
	public static final CopyOnWriteArrayList<Integer> LIST = new CopyOnWriteArrayList<>();
	public static final CountDownLatch LATCH = new CountDownLatch(AMOUNT_THREADS);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new MyThread(i + "-й");
		}

		LATCH.await();
		IntSummaryStatistics statistics = LIST.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("------------\n"+
						   "summa = " + statistics.getSum()		+ "\n" + 
						 "average = " + statistics.getAverage() + "\n" +
						   "count = " + statistics.getCount() 	+ "\n" + 
						     "min = " + statistics.getMin() 	+ "\n" + 
						     "max = " + statistics.getMax());
	}
}
