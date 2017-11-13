package decorator;

public class Main {

	public static void main(String[] args) {
		IPrinter printer = new QuotasDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer())));
		printer.print();
	}
}
