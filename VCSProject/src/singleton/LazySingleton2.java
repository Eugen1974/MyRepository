package singleton;

public class LazySingleton2 {

	private static class Inner {
		private static final LazySingleton2 INSTANCE = new LazySingleton2();
	}

	private LazySingleton2() {
	}

	public static LazySingleton2 getInstance() {
		return Inner.INSTANCE;
	}
}
