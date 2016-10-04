package others;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Person> list=Arrays.asList(new Person("BBB", 8),
										new Person("AAA", 4),
										new Person("CCC", 7),
										new Person("FFF", 3),
										new Person("EEE", 5),
										new Person("KKK", 1));
		list.forEach(System.out::println);
		
//		Predicate
		System.out.println();
		list.stream().filter(person -> person.getAge() > 3).
					  forEach(System.out::println);
//		Function
		System.out.println();
		list.stream().flatMap(person -> Stream.of(1,2,3)).
					  forEach(i -> System.out.print(i + " "));
		
		System.out.println("\n");
		list.stream().map(person -> person.getName()).
					  forEach(System.out::println);
		
//		Consumer
		System.out.println();
		list.stream().peek(person -> person.setName(person.getName().toLowerCase())).
					  forEach(System.out::println);
		
//		BinaryOperator
		System.out.println();
		Optional<Person> person=list.stream().
									 reduce((person1, person2) -> new Person(person1.getName() + " " + person2.getName(),
																		     person1.getAge()  + person2.getAge()));
		if (person.isPresent()) {
			System.out.println(person.get());
		}
		
		System.out.println();
		Stream<String> strStream=Stream.of("111 222 333 444 555 666");
		strStream.flatMap(str -> Arrays.stream(str.split(" "))).
				  forEach(System.out::println);
	}
}
