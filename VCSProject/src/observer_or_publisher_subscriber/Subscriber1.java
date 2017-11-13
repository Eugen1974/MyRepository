package observer_or_publisher_subscriber;

import memento.two.Data;

public class Subscriber1 implements ISubscriber {

	@Override
	public void handleEvent(Data data) {
		System.out.println("Subscriber1::handleEvent " + data);
	}
}
