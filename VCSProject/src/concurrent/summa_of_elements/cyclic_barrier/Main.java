package concurrent.summa_of_elements.cyclic_barrier;

import java.util.IntSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

public class Main {

	public static final int AMOUNT_THREADS = 3;
	public static final CopyOnWriteArrayList<Integer> LIST = new CopyOnWriteArrayList<>();

	public static final CyclicBarrier BARRIER = new CyclicBarrier(AMOUNT_THREADS, () -> {
		IntSummaryStatistics statistics = LIST.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println( "------------\n" + 
							"Марш !\n"   +
							"summa = " 	 + statistics.getSum() 		+ "\n" + 
							"average = " + statistics.getAverage() 	+ "\n" + 
							"count = "   + statistics.getCount() 	+ "\n" + 
							"max = "	 + statistics.getMax() 		+ "\n" + 
							"min = "     + statistics.getMin());
	});

	public static void main(String[] args) {
		for (int i = 0; i < AMOUNT_THREADS; i++) {
			new MyThread(i + "-й");
		}
	}
}
