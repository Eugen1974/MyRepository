package command.one;

public class StopCommand extends AbstractCommand {

	public StopCommand(Computer computer) {
		super(computer);
	}

	@Override
	public void execute() {
		super.getComputer().stop();
	}
}
