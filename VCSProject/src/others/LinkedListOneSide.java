package others;

import java.util.Objects;

public class LinkedListOneSide<T> extends AbstractLinkedList<T> {

	@Override
	protected T doRemove(int position) {
		T result;
		if (size == 1) {
			result = head.getData();
			head = tail = null;
		} else if (position == 0) { // first element
			result = head.getData();
			head = head.getNext();
		} else { // inside of list
			INode<T> previous, current;
			previous = current = head;
			for (int i = 0; i < position; i++) {
				previous = current;
				current = current.getNext();
			}
			if (position == (size - 1)) { // last element
				result = tail.getData();
				tail = previous;
				tail.setNext(null);
			} else {
				result = current.getData(); // previous -> current
				previous.setNext(current.getNext());
				current = null;
			}
		}
		size--;
		return result;
	}

	@Override
	protected void doInsert(int position, T data) {
		INode<T> temp = new NodeOneSide<>(data);
		if (position == 0) { // first element: temporary -> head
			temp.setNext(head.getNext());
			head = temp;
		} else { // inside of list
			INode<T> previous, current;
			previous = current = head;
			for (int i = 0; i < position; i++) {
				previous = current;
				current = current.getNext();
			}
			previous.setNext(temp); // previous -> temporary -> current
			temp.setNext(current); // if it list's end then current is tail
		}
	}

	@Override
	public boolean add(T data) {
		INode<T> temp = new NodeOneSide<>(data);
		if (Objects.isNull(head) || Objects.isNull(tail)) {
			head = tail = temp;
		} else {
			tail.setNext(temp);
			tail = temp;
		}
		size++;
		return true;
	}
}
