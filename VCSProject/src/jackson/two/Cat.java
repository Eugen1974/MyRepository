package jackson.two;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat extends Animal {
	@JsonProperty
	protected String color;

	public Cat() {
	}

	public Cat(int code, String name, String color) {
		super(code, name);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [color=" + color + "]";
	}
}
