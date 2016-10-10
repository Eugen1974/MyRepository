package others;

import java.util.Objects;

public class NodeOneSide<T> implements INode<T> {

	protected T data;
	protected INode<T> next;

	public NodeOneSide(T data) {
		Objects.requireNonNull(data, "data is null !");
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	@Override
	public void clear() {
		data = null;
		next = null;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setNext(INode<T> next) {
		this.next = next;
	}

	@Override
	public INode<T> getNext() {
		return next;
	}

	@Override
	public void setPrevious(INode<T> previous) {
		throw new RuntimeException("setPrevious(): There is no previous element in one-side list !");
	}

	@SuppressWarnings("finally")
	@Override
	public INode<T> getPrevious() {
		try {
			return null;
		} finally {
			throw new RuntimeException("getPrevious(): There is no previous element in one-side list !");
		}
	}
}