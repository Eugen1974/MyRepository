package template_method;

public class Printer1 extends AbstractPrinter {

	@Override
	protected void doPrint() {
		System.out.print("2 ");
	}
}
