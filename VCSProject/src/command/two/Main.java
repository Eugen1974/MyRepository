package command.two;

public class Main {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();

		invoker.setCommand(new Print());
		invoker.executeCommand();

		invoker.setCommand(new PlayMusic());
		invoker.executeCommand();

		invoker.setCommand(new DrawGraphic());
		invoker.executeCommand();
	}
}
