package singleton;

public class Singleton {

	private Singleton() {
	}

	public static Data getInstance() {
		return InnerClass.DATA;
	}

	private static class InnerClass {
		private static final Data DATA = new Data("Привет");
	}

	public static class Data {

		private String str;

		private Data() {
			System.out.println("Creating object Data");
			str = new String();
		}

		private Data(String str) {
			System.out.println("Creating object Data...");
			this.str = str;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		@Override
		public String toString() {
			return "Data [str=" + str + "]";
		}
	}
}
