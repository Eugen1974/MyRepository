package singleton;

import java.util.Objects;

public class LazySingleton {

	private static volatile LazySingleton INSTANCE;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (Objects.isNull(INSTANCE)) {
			synchronized (LazySingleton.class) {
				if (Objects.isNull(INSTANCE)) {
					INSTANCE = new LazySingleton();
				}
			}
		}
		return INSTANCE;
	}
}
