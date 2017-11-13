package command.one;

import command.two.Invoker;

public class Main {

	public static void main(String[] args) {
		Computer computer = new Computer();
		Invoker invoker = new Invoker();

		invoker.setCommand(new StartCommand(computer));
		invoker.executeCommand();

		invoker.setCommand(new StopCommand(computer));
		invoker.executeCommand();

		invoker.setCommand(new ResetCommand(computer));
		invoker.executeCommand();
	}
}
