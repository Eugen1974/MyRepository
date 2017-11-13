package observer_or_publisher_subscriber;

public interface IPublisher {

	boolean addSubscriber(ISubscriber subscriber);

	boolean removeSubscriber(ISubscriber subscriber);

	void notifySubscriber();
}
