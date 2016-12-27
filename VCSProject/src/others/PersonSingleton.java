package others;

public class PersonSingleton {

	private static int counter;

	private PersonSingleton() {
	}

	public static int getCounter() {
		return counter;
	}

	public static Person getInstance() {
		return Inner.PERSON;
	}

	private static class Inner {
		static final Person PERSON = new Person();
	}

	public static class Person {
		private String name;
		private int age;

		private Person() {
			name = new String();
			counter++;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}
}
