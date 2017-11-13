package iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import memento.two.Data;;

public class IIteratorTest {

	protected List list;
	protected IIterator<Data> iterator;

	@Before
	public void before() {
		list = new List();
		list.add(ListTest.DATA_0);
		list.add(ListTest.DATA_1);
		list.add(ListTest.DATA_2);

		iterator = list.getIterator();
	}

	@Test
	public void testFirst() {
		assertEquals(ListTest.DATA_0, iterator.first());
	}

	@Test
	public void testNext() {
		assertEquals(ListTest.DATA_0, iterator.next());
	}

	@Test(expected = RuntimeException.class)
	public void testNextError() {
		for (int i = 0; i < list.getSize(); i++) {
			iterator.next();
		}
		iterator.next();
	}

	@Test
	public void testGetCurrentElement() {
		assertEquals(ListTest.DATA_0, iterator.getCurrentElement());
	}

	@Test(expected = RuntimeException.class)
	public void testGetCurrentElementError() {
		for (int i = 0; i < list.getSize(); i++) {
			iterator.next();
		}
		iterator.getCurrentElement();
	}

	@Test
	public void testHasMoreElements() {
		assertTrue(iterator.hasMoreElements());
		for (int i = 0; i < list.getSize(); i++) {
			iterator.next();
		}
		assertFalse(iterator.hasMoreElements());
	}
}
