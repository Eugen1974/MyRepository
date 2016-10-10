package others;

import java.util.Objects;

public class LinkedListTwoSides<T> extends AbstractLinkedList<T> {

	@Override
	protected void doInsert(int position, T data) {
		INode<T> node = new NodeTwoSides<>(data);
		if (size == 0 && position == 0) {
			head = tail = node;
		} else if (position == 0) { // first element: node <-> head
			head.setPrevious(node);
			node.setNext(head);
			head = node;
		} else {
			INode<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			INode<T> previous = temp.getPrevious(); // inside of list: previous
													// <-> node <-> temporary
			previous.setNext(node);
			node.setPrevious(previous);
			node.setNext(temp);
			temp.setPrevious(node);
		}
	}

	@Override
	protected T doRemove(int position) {
		T result;
		if (size == 1) {
			head = tail = null;
			result = null;
		} else if (position == 0) { // first element
			result = head.getData();
			head = head.getNext();
			head.setPrevious(null);
		} else if (position == (size - 1)) { // last element
			result = tail.getData();
			tail = tail.getPrevious();
			tail.setNext(null);
		} else { // inside of list
			INode<T> temp = head;
			for (int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			result = temp.getData();
			INode<T> previous = temp.getPrevious(); // inside of list: previous
													// - temporary - next
			INode<T> next = temp.getNext();
			previous.setNext(next);
			next.setPrevious(previous);
			temp = null;
		}
		size--;
		return result;
	}

	public boolean addFirst(T data) {
		INode<T> temp = new NodeTwoSides<>(data);
		if (Objects.isNull(head) || Objects.isNull(tail)) {
			head = tail = temp;
		} else {
			head.setPrevious(temp); // temporary - head
			temp.setNext(head);
			head = temp;
		}
		size++;
		return true;
	}

	@Override
	public boolean add(T data) {
		INode<T> temp = new NodeTwoSides<>(data);
		if (Objects.isNull(head) || Objects.isNull(tail)) {
			head = tail = temp;
		} else {
			tail.setNext(temp); // tail - temporary
			temp.setPrevious(tail);
			tail = temp;
		}
		size++;
		return true;
	}

	public void showAllFromTail() {
		INode<T> temp = tail;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.getData() + " ");
			temp = temp.getPrevious();
		}
		System.out.println();
	}
}
