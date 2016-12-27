package others;

import java.util.List;

public abstract class AbstractEx<T> implements IEx<T> {

	protected abstract List<T> doGetList();

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList() {
		List<T> list = doGetList();
		list.sort((ob1, ob2) -> (-1) * ((Comparable<T>) ob1).compareTo(ob2));
		return list;
	}
}
