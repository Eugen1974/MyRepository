package chain_of_responsibility.three;

public final class Util {

	private Util() {
	}

	public static final boolean canHandleMessage(Level handler, Level message) {
		return message.getNum() <= handler.getNum();
	}
}
