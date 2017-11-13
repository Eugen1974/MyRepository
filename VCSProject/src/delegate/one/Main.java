package delegate.one;

public class Main {

	public static void main(String[] args) {
		B b = new B();
		b.setA(new A());
		b.f();
	}
}
