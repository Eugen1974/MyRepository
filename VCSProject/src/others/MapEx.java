package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEx extends AbstractEx<Float> {

	@Override
	protected List<Float> doGetList() {
		Map<Integer, Float> map = new HashMap<>();
		map.put(1, 1.1F);
		map.put(2, 2.2F);
		map.put(3, 3.3F);
		return new ArrayList<>(map.values());
	}
}
