package others;

import java.util.Iterator;

public interface IList<T> extends Iterable<T>, Iterator<T> {
	
	boolean add(T value);
	
	void checkBounds(int position);

	void clear();

	T getHead();

	int getIndex(T data);

	int getSize();

	T getTail();

	T getValue(int position);

	void insert(int position, T data);

	T remove(int position);
	
	String toString();
}
