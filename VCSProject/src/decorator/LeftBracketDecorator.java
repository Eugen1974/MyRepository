package decorator;

public class LeftBracketDecorator extends AbstractPrinterDecorator {

	public LeftBracketDecorator(IPrinter printer) {
		super(printer);
	}

	@Override
	public void print() {
		System.out.print("[");
		super.getPrinter().print();
	}
}
