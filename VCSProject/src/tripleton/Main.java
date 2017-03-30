package tripleton;

public class Main {

	public static void main(String[] args) {
		LazyTripleton.Person[] persons = LazyTripleton.getPersons();
		persons[0].setAge(10);
		persons[0].setName("десять");
		persons[1].setAge(11);
		persons[1].setName("одиннадцать");
		persons[2].setAge(12);
		persons[2].setName("двенадцать");
		for (LazyTripleton.Person p : persons) {
			System.out.println(p);
		}

		LazyTripleton.Person person = LazyTripleton.getPerson(1);
		person.setAge(1);
		person.setName("один");
		System.out.println("\n" + person);
	}
}
