package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayListTest<T> extends AbstractListTest<T> {

	public ArrayListTest() {
		super(new ArrayList<>());
	}

	@Test
	public void testGetArrayLength() {
		assertEquals(4, ((ArrayList<T>) list).getArrayLength());
	}

	@Test
	public void testTrimToSize() {
		((ArrayList<T>) list).trimToSize();
		assertEquals(3, ((ArrayList<T>) list).getArrayLength());
		assertEquals(3, list.getSize());
	}
}