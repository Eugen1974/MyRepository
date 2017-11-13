package iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import memento.two.Data;

public class ListTest {

	public static final Data DATA_0 = new Data("000");
	public static final Data DATA_1 = new Data("111");
	public static final Data DATA_2 = new Data("222");
	public static final Data DATA_3 = new Data("333");

	protected List list;

	@Before
	public void before() {
		list = new List();
		list.add(DATA_0);
		list.add(DATA_1);
		list.add(DATA_2);
	}

	@Test
	public void testAdd() {
		list.add(DATA_3);
		assertEquals(4, list.getSize());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddError() {
		for (int i = list.getSize(); i < List.MAX_AMOUNT_ELEMENTS; i++) {
			list.add(DATA_0);
		}
		list.add(DATA_0);
	}

	@Test
	public void testRemoveData() {
		assertTrue(list.remove(DATA_1));
		assertEquals(2, list.getSize());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveDataError() {
		list.remove(DATA_3);
	}

	@Test
	public void testRemoveInt() {
		assertEquals(DATA_1, list.remove(1));
		assertEquals(2, list.getSize());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveIntError() {
		list.remove(3);
	}

	@Test
	public void testGetSize() {
		assertEquals(3, list.getSize());
	}

	@Test
	public void testToString() {
		assertEquals("List [list=[Data [str=000], Data [str=111], Data [str=222]], counter=3]", list.toString());
	}

	@Test
	public void testGetIterator() {
		assertNotNull(list.getIterator());
	}
}
