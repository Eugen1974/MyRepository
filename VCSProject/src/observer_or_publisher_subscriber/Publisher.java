package observer_or_publisher_subscriber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import memento.two.Data;

public class Publisher implements IPublisher {

	private Data data;
	private List<ISubscriber> subscribers;

	public Publisher() {
		this(new Data());
	}

	public Publisher(Data data) {
		this(data, new ArrayList<>());
	}

	public Publisher(Data data, List<ISubscriber> subscribers) {
		this.data = data;
		this.subscribers = subscribers;
	}

	public boolean addSubscribers(List<ISubscriber> subscribers) {
		return this.subscribers.addAll(subscribers);
	}

	public boolean addSubscribers(ISubscriber... subscribers) {
		return addSubscribers(Arrays.asList(subscribers));
	}

	@Override
	public boolean addSubscriber(ISubscriber subscriber) {
		return subscribers.add(subscriber);
	}

	@Override
	public boolean removeSubscriber(ISubscriber subscriber) {
		return subscribers.remove(subscriber);
	}

	@Override
	public void notifySubscriber() {
		subscribers.forEach(subscriber -> subscriber.handleEvent(data));
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
		notifySubscriber();
	}
}
