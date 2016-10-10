package others;

public abstract class AbstractList<T> implements IList<T> {
	protected int size;

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void checkBounds(int position) {
		if (size == 0) {
			throw new RuntimeException("List is empty ! size=0");
		}
		if (position < 0 || position >= size) {
			throw new IndexOutOfBoundsException("Wrong index list's element ! position=" + position + " size=" + size);
		}
	}
}
