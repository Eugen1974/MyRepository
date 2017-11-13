package prototype;

public class Main {

	public static void main(String[] args) {
		Fabrica fabrica = new Fabrica();

		Data data = new Data("Привет");
		System.out.println("     " + data);

		fabrica.setCopy(data);
		ICopy copy = fabrica.makeCopy();
		System.out.println("Copy " + copy + "\n");

		Person person = new Person(20, "Женя");
		System.out.println("     " + person);

		fabrica.setCopy(person);
		copy = fabrica.makeCopy();
		System.out.println("Copy " + copy);
	}
}
