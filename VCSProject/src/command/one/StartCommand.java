package command.one;

public class StartCommand extends AbstractCommand {

	public StartCommand(Computer computer) {
		super(computer);
	}

	@Override
	public void execute() {
		super.getComputer().start();
	}
}
