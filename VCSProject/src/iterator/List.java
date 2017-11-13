package iterator;

import java.util.ArrayList;

import memento.two.Data;

public class List implements IList<Data> {

	public static final int MAX_AMOUNT_ELEMENTS = 5;

	private java.util.List<Data> list;
	private int counter;

	public List() {
		list = new ArrayList<>();
		counter = 0;
	}

	public boolean add(Data data) {
		if (counter < MAX_AMOUNT_ELEMENTS) {
			counter++;
			return list.add(data);
		}
		throw new IndexOutOfBoundsException(
				"Exceeded amount elements ! counter = " + counter + ", MAX_AMOUNT_ELEMENTS = " + MAX_AMOUNT_ELEMENTS);

	}

	public boolean remove(Data data) {
		if (list.remove(data)) {
			counter--;
			return true;
		}
		throw new IllegalArgumentException("There is no object " + data + " in list !");
	}

	public Data remove(int index) {
		if (index < counter) {
			counter--;
			return list.remove(index);
		}
		throw new IllegalArgumentException("Wrong index ! index = " + index + ", counter = " + counter);
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public String toString() {
		return "List [list=" + list + ", counter=" + counter + "]";
	}

	@Override
	public IIterator<Data> getIterator() {
		return new Iterator();
	}

	private class Iterator implements IIterator<Data> {

		private Iterator() {
			counter = 0;
		}

		@Override
		public Data first() {
			return list.get(0);
		}

		@Override
		public Data next() {
			if (hasMoreElements()) {
				return list.get(counter++);
			}
			throw new RuntimeException("There is no next element ! counter = " + counter);
		}

		@Override
		public Data getCurrentElement() {
			if (hasMoreElements()) {
				return list.get(counter);
			}
			throw new RuntimeException("Exceeded size list ! counter = " + counter);
		}

		@Override
		public boolean hasMoreElements() {
			return counter < list.size();
		}
	}
}
