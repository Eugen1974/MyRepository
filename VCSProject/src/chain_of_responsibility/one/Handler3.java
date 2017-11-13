package chain_of_responsibility.one;

public class Handler3 extends AbstractHandler {

	@Override
	public void handleMessage() {
		System.out.println("Handler3::handleMessage");
	}
}
