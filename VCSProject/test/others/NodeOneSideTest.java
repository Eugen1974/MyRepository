package others;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class NodeOneSideTest<T> implements INodeTest {

	protected INode<T> node;

	public NodeOneSideTest() {
		node = new NodeOneSide<>((T) DATA);
	}

	@Test
	public void testToString() {
		assertEquals("Node [data=" + DATA + "]", node.toString());
	}

	@Test
	public void testClear() {
		node.clear();
		assertNull(node.getData());
		assertNull(node.getNext());
	}

	@Test
	public void testGetData() {
		assertEquals(DATA, node.getData());
	}

	@Test
	public void testSetNext() {
		testGetNext();
	}

	@Test
	public void testGetNext() {
		INode<T> next = new NodeOneSide<>((T) DATA);
		node.setNext(next);
		assertEquals(next, node.getNext());
	}

	@Test(expected = RuntimeException.class)
	public void testSetPrevious() {
		node.setPrevious(null);
	}

	@Test(expected = RuntimeException.class)
	public void testGetPrevious() {
		node.getPrevious();
	}
}
