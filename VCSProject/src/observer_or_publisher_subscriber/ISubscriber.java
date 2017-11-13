package observer_or_publisher_subscriber;

import memento.two.Data;

public interface ISubscriber {

	void handleEvent(Data data);
}
