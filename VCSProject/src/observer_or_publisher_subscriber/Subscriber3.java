package observer_or_publisher_subscriber;

import memento.two.Data;

public class Subscriber3 implements ISubscriber {

	@Override
	public void handleEvent(Data data) {
		System.out.println("Subscriber3::handleEvent " + data);
	}
}
