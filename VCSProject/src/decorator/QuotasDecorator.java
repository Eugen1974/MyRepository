package decorator;

public class QuotasDecorator extends AbstractPrinterDecorator {

	public QuotasDecorator(IPrinter printer) {
		super(printer);
	}

	@Override
	public void print() {
		System.out.print("\"");
		super.getPrinter().print();
		System.out.print("\"");
	}
}
