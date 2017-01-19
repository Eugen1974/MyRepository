package lambda1;

public class Main {
	public static void main(String[] args) {
		IPersonFabrica<Person> fabrica = Person::new;
		Person person = fabrica.create("Женя", 16);
		System.out.println(person);

		fabrica = Son::new;
		person = fabrica.create("Илья", 10);
		System.out.println(person);
	}
}