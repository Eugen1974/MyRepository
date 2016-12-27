package others;

import java.util.Arrays;
import java.util.List;

public class ArrayEx extends AbstractEx<String> {

	@Override
	protected List<String> doGetList() {
		String[] array = { "AAA", "BBB", "CCC" };
		return Arrays.asList(array);
	}
}
