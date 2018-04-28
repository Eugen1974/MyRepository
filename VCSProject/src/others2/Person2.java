package others2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person2 {

	private SimpleStringProperty name;
	private SimpleIntegerProperty age;

	public Person2(String name, int age) {
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name.get() + ", age=" + age.get() + "]";
	}

	public SimpleStringProperty getPropertyName() {
		return name;
	}

	public SimpleIntegerProperty getPropertyAge() {
		return age;
	}
}
