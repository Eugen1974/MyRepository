package others;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class NodeTwoSidesTest<T> extends NodeOneSideTest<T> {

	public NodeTwoSidesTest() {
		node = new NodeTwoSides<>((T) DATA);
	}

	@Test
	public void testClear() {
		super.testClear();
		assertNull(node.getPrevious());
	}

	@Test
	public void testSetPrevious() {
		testGetPrevious();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetPreviousError() {
		node.setPrevious(new NodeOneSide<>((T) DATA));
	}

	@Test
	public void testGetPrevious() {
		INode<T> previous = new NodeTwoSides<>((T) DATA);
		node.setPrevious(previous);
		assertEquals(previous, node.getPrevious());
	}
}
