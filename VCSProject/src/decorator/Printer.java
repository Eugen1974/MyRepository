package decorator;

public class Printer implements IPrinter {

	@Override
	public void print() {
		System.out.print("Привет");
	}
}
