package others;

import org.junit.Test;

public abstract class AbstractLinkedListTest<T> extends AbstractListTest<T> {

	public AbstractLinkedListTest(IList<T> list) {
		super(list);
	}

	@Test
	public void testShowAllFromHead() {
		System.out.println("\nshowAllFromHead\n---------------");
		((AbstractLinkedList<T>) list).showAllFromHead();
	}
}