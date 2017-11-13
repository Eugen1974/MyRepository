package decorator;

public class RightBracketDecorator extends AbstractPrinterDecorator {

	public RightBracketDecorator(IPrinter printer) {
		super(printer);
	}

	@Override
	public void print() {
		super.getPrinter().print();
		System.out.print("]");
	}
}
