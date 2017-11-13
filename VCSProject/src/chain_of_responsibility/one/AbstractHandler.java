package chain_of_responsibility.one;

public abstract class AbstractHandler implements IHandler {

	private IHandler nextHandler;

	public IHandler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(IHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
}
