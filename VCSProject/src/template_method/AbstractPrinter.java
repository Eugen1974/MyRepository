package template_method;

public abstract class AbstractPrinter implements IPrint {

	protected abstract void doPrint();

	@Override
	public void print() {
		System.out.print("1 ");
		doPrint();
		System.out.println("3");
	}
}
