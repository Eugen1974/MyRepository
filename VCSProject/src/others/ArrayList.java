package others;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList<T> extends AbstractList<T> {
	private T[] array;
	private int currentPosition;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		array = (T[]) new Object[0];
	}

	private boolean increaseArray() {
		if (size == 0 || size >= array.length) {
			array = Arrays.copyOf(array, (3 * size / 2) + 1);
			return true;
		}
		return false;
	}

	@Override
	public boolean add(T value) {
		// -------------
		increaseArray();
		// -------------
		array[size] = value; // last element
		size++;
		return true;
	}

	@Override
	public T remove(int position) {
		// -------------------
		checkBounds(position);
		// -------------------
		T result = array[position];
		System.arraycopy(array, position + 1, array, position, size - position - 1);
		array[size - 1] = null; // delete last element
		size--;
		return result;
	}

	@Override
	public T getValue(int position) {
		// -------------------
		checkBounds(position);
		// -------------------
		return array[position];
	}

	public int getArrayLength() {
		return array.length;
	}

	@Override
	public String toString() {
		T[] temp = Arrays.copyOfRange(array, 0, size);
		return "ArrayList=" + Arrays.toString(temp);
	}

	@Override
	public Iterator<T> iterator() {
		currentPosition = 0;
		return this;
	}

	@Override
	public boolean hasNext() {
		return currentPosition >= 0 && currentPosition < size;
	}

	@Override
	public T next() {
		if (hasNext()) {
			return array[currentPosition++];
		} else {
			throw new NoSuchElementException(
					"Wrong array's index ! currentPosition=" + currentPosition + " size=" + size);
		}
	}

	@Override
	public void insert(int position, T data) {
		// -------------------
		checkBounds(position);
		// -------------------
		size++;
		// -------------
		increaseArray();
		// -------------
		System.arraycopy(array, position, array, position + 1, array.length - position - 1);
		array[position] = data;
	}

	@Override
	public int getIndex(T data) {
		for (int i = 0; i < size; i++) {
			if (Objects.equals(array[i], data)) {
				return i;
			}
		}
		return -1; // nothing
	}

	@Override
	public T getHead() {
		return array[0];
	}

	@Override
	public T getTail() {
		// --------------------
		checkBounds(size - 1);
		// --------------------
		return array[size - 1];
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}

	public void trimToSize() {
		if (size < array.length) {
			array = Arrays.copyOf(array, size);
		}
	}
}
