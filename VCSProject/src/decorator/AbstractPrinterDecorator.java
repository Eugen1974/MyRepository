package decorator;

public abstract class AbstractPrinterDecorator implements IPrinter {

	private IPrinter printer;

	public AbstractPrinterDecorator(IPrinter printer) {
		this.printer = printer;
	}

	public IPrinter getPrinter() {
		return printer;
	}

	public void setPrinter(IPrinter printer) {
		this.printer = printer;
	}
}
