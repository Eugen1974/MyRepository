package others;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public abstract class AbstractListTest<T> implements IListTest {

	protected IList<T> list;

	public AbstractListTest(IList<T> list) {
		this.list = list;
	}

	@Before
	public void before() {
		list.clear();
		list.add((T) OBJECT_0);
		list.add((T) OBJECT_1);
		list.add((T) OBJECT_2);
	}

	@Test
	public void testGetSize() {
		assertEquals(3, list.getSize());
	}

	@Test
	public void testCheckBounds() {
		list.checkBounds(1);
	}

	@Test(expected = RuntimeException.class)
	public void testCheckBoundsError1() {
		list.clear();
		list.checkBounds(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testCheckBoundsError2() {
		list.checkBounds(4);
	}

	@Test
	public void testAdd() {
		assertTrue(list.add((T) OBJECT_3));
		assertEquals(OBJECT_3, list.getValue(3));
		assertEquals(4, list.getSize());
	}

	@Test
	public void testGetHead() {
		assertEquals(OBJECT_0, list.getHead());
	}

	@Test
	public void testGetTail() {
		assertEquals(OBJECT_2, list.getTail());
	}

	@Test
	public void testRemove() {
		assertEquals(OBJECT_1, list.remove(1));
		assertEquals(2, list.getSize());
	}

	@Test
	public void testGetValue() {
		assertEquals(OBJECT_2, list.getValue(2));
	}

	@Test
	public void testIterator() {
		Iterator<T> iterator = list.iterator();
		assertNotNull(iterator);
		assertEquals(OBJECT_0, iterator.next());
	}

	@Test
	public void testHasNext() {
		list.iterator();
		assertTrue(list.hasNext());
	}

	@Test
	public void testNext() {
		list.iterator();
		assertEquals(OBJECT_0, list.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextError() {
		while (list.hasNext()) {
			list.next();
		}
		list.next();
	}

	@Test
	public void testToString() {
		assertNotNull(list.toString());
		System.out.println("\n" + list);
	}

	@Test
	public void testInsert() {
		list.insert(1, (T) OBJECT_3);
		assertEquals(OBJECT_3, list.getValue(1));
	}

	@Test
	public void testGetIndex() {
		assertEquals(1, list.getIndex((T) OBJECT_1));
		assertEquals(-1, list.getIndex((T) OBJECT_3));
	}

	@Test
	public void testClear() {
		list.clear();
		assertEquals(0, list.getSize());
	}
}