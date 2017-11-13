package command.one;

public class ResetCommand extends AbstractCommand {

	public ResetCommand(Computer computer) {
		super(computer);
	}

	@Override
	public void execute() {
		super.getComputer().reset();
	}
}
