package command.two;

public class Invoker {

	private ICommand command;

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void executeCommand() {
		command.execute();
	}
}
