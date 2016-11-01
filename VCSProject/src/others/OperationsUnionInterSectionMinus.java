package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OperationsUnionInterSectionMinus {

	public static void main(String[] args) {
		System.out.printf("%19s %s\n", "list1 =", getList1());
		System.out.printf("%19s %s\n", "list2 =", getList2() + "\n");

		List<String> list1 = getList1();
		list1.addAll(getList2());
		System.out.printf("%19s %s\n", "UnionAll =", list1);

		System.out.printf("%19s %s\n", "Union =", list1.stream()
													   .distinct()
													   .collect(Collectors.toList()));
		list1 = getList1();
		list1.retainAll(getList2());
		System.out.printf("%19s %s\n", "InterSection =", list1);

		list1 = getList1();
		list1.removeAll(getList2());
		System.out.printf("%19s %s\n", "list1 - list2 =", list1);

		List<String> list2 = getList2();
		list2.removeAll(getList1());
		System.out.printf("%19s %s\n\n", "list2 - list1 =", list2);
		
		list1 = getList1();
		Collections.reverse(list1);
		System.out.printf("%19s %s\n", "reverse list1 =", list1);

		list2 = getList2();
		Collections.reverse(list2);
		System.out.printf("%19s %s\n\n", "reverse list2 =", list2);
		
		list1 = getList1();
		list1.removeAll(getList2()); // list1 - list2

		list2 = getList2();
		list2.removeAll(getList1()); // list2 - list1

		list1.addAll(list2); 		 // list1 + list2
		System.out.printf("%19s %s\n", "union differences =", list1);
	}

	public static List<String> getList1() {
		return new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
	}

	public static List<String> getList2() {
		return new ArrayList<>(Arrays.asList("C", "D", "E", "F"));
	}
}
