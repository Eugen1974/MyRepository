package others;

import java.util.ArrayList;
import java.util.List;

public class ListEx extends AbstractEx<Integer> {

	@Override
	protected List<Integer> doGetList() {
		List<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		list.add(333);
		return list;
	}
}
