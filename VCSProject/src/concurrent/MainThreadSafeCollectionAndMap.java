package concurrent;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class MainThreadSafeCollectionAndMap {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("AAA", "BBB", "CCC"));
		System.out.println("CopyOnWriteArrayList:  " + list);

		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>(Arrays.asList("aaa", "bbb", "ccc"));
		System.out.println("CopyOnWriteArraySet:   " + set);

		ConcurrentSkipListSet<String> set1 = new ConcurrentSkipListSet<>(Arrays.asList("111", "222", "333"));
		System.out.println("\nConcurrentSkipListSet: " + set1);

		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>(Arrays.asList("AAA", "BBB", "CCC"));
		System.out.println("ConcurrentLinkedQueue: " + queue);

		ConcurrentLinkedDeque<String> dequeu = new ConcurrentLinkedDeque<>(Arrays.asList("aaa", "bbb", "ccc"));
		System.out.println("ConcurrentLinkedDeque: " + dequeu);

		ConcurrentHashMap<Integer, String> map1 = new ConcurrentHashMap<>();
		map1.put(3, "CCC");
		map1.put(2, "BBB");
		map1.put(1, "AAA");
		System.out.println("\nConcurrentHashMap:     " + map1);

		ConcurrentSkipListMap<Integer, String> map2 = new ConcurrentSkipListMap<>();
		map2.put(3, "ccc");
		map2.put(2, "bbb");
		map2.put(1, "aaa");
		System.out.println("ConcurrentSkipListMap: " + map2);
	}
}