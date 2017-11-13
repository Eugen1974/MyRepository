package chain_of_responsibility.three;

public class Handler3 extends AbstractHandler {

	public Handler3(Level levelHandler) {
		super(levelHandler);
	}

	@Override
	protected void doHandleMessage(Level level, String message) {
		System.out.println("Handler3: " + level.name() + ", level=" + level.getNum() + ", message=" + message);
	}
}
