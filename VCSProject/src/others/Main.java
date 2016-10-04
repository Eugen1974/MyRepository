package others;

public class Main implements IMy {
	@Override
	public void f() {
		// RuntimeException and its subclasses are unchecked exceptions.
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		new Main().f();
	}
}
