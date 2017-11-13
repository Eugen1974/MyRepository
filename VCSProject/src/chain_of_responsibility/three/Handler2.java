package chain_of_responsibility.three;

public class Handler2 extends AbstractHandler {

	public Handler2(Level levelHandler) {
		super(levelHandler);
	}

	@Override
	protected void doHandleMessage(Level level, String message) {
		System.out.println("Handler2: " + level.name() + ", level=" + level.getNum() + ", message=" + message);
	}
}
