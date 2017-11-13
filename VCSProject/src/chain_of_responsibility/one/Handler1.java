package chain_of_responsibility.one;

public class Handler1 extends AbstractHandler {

	@Override
	public void handleMessage() {
		System.out.println("Handler1::handleMessage");
		getNextHandler().handleMessage();
	}
}
