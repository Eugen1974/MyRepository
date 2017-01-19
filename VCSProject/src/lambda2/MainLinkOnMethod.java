package lambda2;

import java.util.Arrays;
import java.util.List;

public class MainLinkOnMethod {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("A", "B", "C", "D");
		List<String> list2 = Arrays.asList("C", "D", "E", "F");

		list1.stream()
			 .map(String::toLowerCase)
			 .forEach(System.out::println);
		
		System.out.println();
		
		list1.stream()
			 .filter(list2::contains)
			 .forEach(System.out::println);
		
		System.out.println();
		
		list1.stream()
			 .map(My::new)
			 .forEach(System.out::println);
	}
}
