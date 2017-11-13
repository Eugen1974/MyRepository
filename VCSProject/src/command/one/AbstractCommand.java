package command.one;

import command.two.ICommand;

public abstract class AbstractCommand implements ICommand {

	private Computer computer;

	public AbstractCommand(Computer computer) {
		this.computer = computer;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
