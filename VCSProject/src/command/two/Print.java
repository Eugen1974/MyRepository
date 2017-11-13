package command.two;

public class Print implements ICommand {

	private Printer printer;

	public Print() {
		printer = new Printer();
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void execute() {
		printer.print();
	}
}
