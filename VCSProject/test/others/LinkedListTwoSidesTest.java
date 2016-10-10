package others;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class LinkedListTwoSidesTest<T> extends AbstractLinkedListTest<T> {

	public LinkedListTwoSidesTest() {
		super(new LinkedListTwoSides<>());
	}

	@Test
	public void testAddFirst() {
		assertTrue(((LinkedListTwoSides<T>) list).addFirst((T) OBJECT_3));
		assertEquals(OBJECT_3, list.getValue(0));
		assertEquals(4, list.getSize());
	}

	@Test
	public void testShowAllFromTail() {
		System.out.println("\nshowAllFromTail\n---------------");
		((LinkedListTwoSides<T>) list).showAllFromTail();
	}
}