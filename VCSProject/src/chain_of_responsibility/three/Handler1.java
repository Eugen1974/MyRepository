package chain_of_responsibility.three;

public class Handler1 extends AbstractHandler {

	public Handler1(Level levelHandler) {
		super(levelHandler);
	}

	@Override
	protected void doHandleMessage(Level level, String message) {
		System.out.println("Handler1: " + level.name() + ", level=" + level.getNum() + ", message=" + message);
	}
}
