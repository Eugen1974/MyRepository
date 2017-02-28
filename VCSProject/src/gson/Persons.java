package gson;

import java.util.List;

public class Persons {

	private List<Person> persons;

	public Persons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Persons [persons=" + persons + "]";
	}
}
