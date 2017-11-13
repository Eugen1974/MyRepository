package visitor.one;

public class Main {

	public static void main(String[] args) {
		Visitor1 visitor1 = new Visitor1();
		Visitor2 visitor2 = new Visitor2();
		Visitor3 visitor3 = new Visitor3();
		
		Element1 element1 = new Element1("element1");
		Element2 element2 = new Element2("element2");

		element1.accept(visitor1);
		element1.accept(visitor2);
		element1.accept(visitor3);

		System.out.println();

		element2.accept(visitor1);
		element2.accept(visitor2);
		element2.accept(visitor3);
	}
}
