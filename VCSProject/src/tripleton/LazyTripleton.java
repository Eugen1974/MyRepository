package tripleton;

public class LazyTripleton {

	private static class Inner {
		private static final int ARRAY_SIZE = 3;
		private static final Person[] PERSONS = new Person[ARRAY_SIZE];
		static {
			for (int i = 0; i < ARRAY_SIZE; i++) {
				PERSONS[i] = new Person();
			}
		}
	}

	private LazyTripleton() {
	}

	public static Person[] getPersons() {
		return Inner.PERSONS;
	}

	public static Person getPerson(int index) {
		if (index < 0 || index >= Inner.ARRAY_SIZE) {
			throw new ArrayIndexOutOfBoundsException("wrong index " + index);
		}
		return Inner.PERSONS[index];
	}

	public static class Person {
		private int age;
		private String name;

		private Person() {
			name = new String();
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}
	}
}
