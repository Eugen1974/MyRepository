package chain_of_responsibility.one;

public class Handler2 extends AbstractHandler {

	@Override
	public void handleMessage() {
		System.out.println("Handler2::handleMessage");
		getNextHandler().handleMessage();
	}
}
