package iterator;

public interface IIterator<T> {

	T first();

	T next();

	T getCurrentElement();

	boolean hasMoreElements();
}
