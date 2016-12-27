package others;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public abstract class AbstractExTest<T> implements IExTest<T> {

	protected IEx<T> ob;

	public AbstractExTest(IEx<T> ob) {
		this.ob = ob;
	}

	@Test
	public void testDoGetList() {
		List<T> list = ((AbstractEx<T>) ob).doGetList();
		if (ob instanceof ArrayEx) {
			assertEquals(Arrays.asList("AAA", "BBB", "CCC"), list);
		} else if (ob instanceof ListEx) {
			assertEquals(Arrays.asList(111, 222, 333), list);
		} else if (ob instanceof MapEx) {
			assertEquals(Arrays.asList(1.1F, 2.2F, 3.3F), list);
		} else {
			fail("Not yet implemented for " + ob.getClass().getName());
		}
	}

	@Test
	public void testGetList() {
		List<T> list = ob.getList();
		if (ob instanceof ArrayEx) {
			assertEquals(Arrays.asList("CCC", "BBB", "AAA"), list);
		} else if (ob instanceof ListEx) {
			assertEquals(Arrays.asList(333, 222, 111), list);
		} else if (ob instanceof MapEx) {
			assertEquals(Arrays.asList(3.3F, 2.2F, 1.1F), list);
		} else {
			fail("Not yet implemented for " + ob.getClass().getName());
		}
	}
}