package concurrent.stack;

import java.util.ArrayList;
import java.util.List;

public class Data<T> {

	public static final int LENGTH = 3;

	private List<T> list;
	private int size;

	public Data() {
		list = new ArrayList<>();
		size = 0;
	}

	public boolean put(T ob) {
		if (size < LENGTH) {
			list.add(ob);
			size++;
			return true;
		}
		throw new IndexOutOfBoundsException(
				"Cannot do operation put ! size=" + size + ". Must be between 1 & " + LENGTH);
	}

	public T get() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Cannot do operation get ! size=" + size);
		}
		T ob = list.remove(size - 1);
		size--;
		return ob;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Data [list=" + list + ", size=" + size + "]";
	}
}
