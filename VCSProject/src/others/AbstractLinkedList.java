package others;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class AbstractLinkedList<T> extends AbstractList<T> {

	protected INode<T> head;
	protected INode<T> tail;
	protected INode<T> currentElement;

	protected abstract void doInsert(int position, T data);

	protected abstract T doRemove(int position);

	@Override
	public T getHead() {
		if (Objects.nonNull(head)) {
			return head.getData();
		}
		return null;
	}

	@Override
	public int getIndex(T data) {
		INode<T> temp = head;
		for (int i = 0; i < size; i++) {
			if (Objects.equals(temp.getData(), data)) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1; // nothing
	}

	@Override
	public T getTail() {
		if (Objects.nonNull(tail)) {
			return tail.getData();
		}
		return null;
	}

	@Override
	public T getValue(int position) {
		// --------------------
		checkBounds(position);
		// --------------------
		if (position == (size - 1)) {
			return tail.getData();
		} else {
			INode<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			return temp.getData();
		}
	}

	@Override
	public String toString() {
		String strHead = Objects.nonNull(head) ? head.getData().toString() : null;
		String strTail = Objects.nonNull(tail) ? tail.getData().toString() : null;
		String strCurrentElement = Objects.nonNull(currentElement) ? currentElement.getData().toString() : null;

		return getClass().getSimpleName() + " [head=" + strHead + ", tail=" + strTail + ", size=" + size
				+ ", currentElement=" + strCurrentElement + "]";
	}

	@Override
	public Iterator<T> iterator() {
		currentElement = head;
		return this;
	}

	@Override
	public boolean hasNext() {
		return Objects.nonNull(currentElement);
	}

	@Override
	public T next() {
		if (hasNext()) {
			try {
				return currentElement.getData();
			} finally {
				currentElement = currentElement.getNext();
			}
		} else {
			throw new NoSuchElementException("CurrentElement is empty !");
		}
	}

	@Override
	public void clear() {
		INode<T> previous, current;
		previous = current = head;
		for (int i = 0; i < size; i++) {
			previous = current;
			current = current.getNext();
			previous.clear();
			previous = null;
		}
		head = tail = null;
		size = 0;
	}

	@Override
	public void insert(int position, T data) {
		// --------------------
		checkBounds(position);
		// ----------------------
		doInsert(position, data);
		// ----------------------
		size++;
	}

	@Override
	public T remove(int position) {
		// --------------------
		checkBounds(position);
		// -----------------------
		return doRemove(position);
		// -----------------------
	}

	public void showAllFromHead() {
		INode<T> temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
