package others;

public class NodeTwoSides<T> extends NodeOneSide<T> {

	protected NodeTwoSides<T> previous;

	public NodeTwoSides(T data) {
		super(data);
	}

	@Override
	public void clear() {
		super.clear();
		previous = null;
	}

	@Override
	public void setPrevious(INode<T> previous) {
		if (previous instanceof NodeTwoSides) {
			this.previous = (NodeTwoSides<T>) previous;
		} else {
			throw new IllegalArgumentException(
					"Illegal type " + previous.getClass().getName() + " for previous element !");
		}
	}

	@Override
	public INode<T> getPrevious() {
		return previous;
	}
}
