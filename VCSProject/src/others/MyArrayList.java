package others;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T>, Iterator<T> {
	private T[] array;
	private int position;

	@SuppressWarnings("unchecked")
	public MyArrayList(T... ob) {
		array = ob;
	}

	public void add(T ob) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = ob;
	}

	@Override
	public void remove() {
		System.arraycopy(array, position + 1, array, position, array.length - position - 1);
		array = Arrays.copyOf(array, array.length - 1);
		position--;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	@Override
	public Iterator<T> iterator() {
		position = -1;
		return this;
	}

	@Override
	public boolean hasNext() {
		if ((position + 1) >= 0 && (position + 1) < array.length) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (hasNext()) {
			position++;
			return array[position];
		}
		throw new IndexOutOfBoundsException("Wrong index ! position=" + position + " array length=" + array.length);
	}

	public int size() {
		return array.length;
	}
}
