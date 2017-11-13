package observer_or_publisher_subscriber;

import memento.two.Data;

public class Main {

	public static void main(String[] args) {
		Subscriber1 subscriber1 = new Subscriber1();
		Subscriber2 subscriber2 = new Subscriber2();
		Subscriber3 subscriber3 = new Subscriber3();

		Publisher publisher = new Publisher();
		publisher.addSubscribers(subscriber1, subscriber2, subscriber3);

		publisher.setData(new Data("111"));

		publisher.removeSubscriber(subscriber2);

		System.out.println();
		publisher.setData(new Data("222"));
	}
}
