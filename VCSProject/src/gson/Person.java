package gson;

import java.time.LocalDate;

public class Person {

	private int id;
	private String name;
	private LocalDate bithDay;

	public Person(int id, String name, LocalDate bithDay) {
		this.id = id;
		this.name = name;
		this.bithDay = bithDay;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", bithDay=" + bithDay + "]";
	}
}
