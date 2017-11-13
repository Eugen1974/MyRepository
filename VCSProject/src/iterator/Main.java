package iterator;

import memento.two.Data;

public class Main {

	public static void main(String[] args) {
		List list = new List();
		list.add(new Data("000"));
		list.add(new Data("111"));
		list.add(new Data("222"));
		list.add(new Data("333"));
		list.add(new Data("444"));
		// list.add(new Data("555"));
		System.out.println(list);

		list.remove(new Data("111"));
		System.out.println(list);

		// list.remove(4);
		list.remove(3);
		System.out.println(list);

		System.out.println("size = " + list.getSize());

		IIterator<Data> iterator = list.getIterator();
		System.out.println("first element = " + iterator.first());
		while (iterator.hasMoreElements()) {
			System.out.println(iterator.getCurrentElement());
			iterator.next();
		}
		// iterator.next();
		// iterator.getCurrentElement();
	}
}
