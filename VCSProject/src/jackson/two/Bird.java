package jackson.two;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bird extends Animal {
	@JsonProperty
	protected boolean canSing;

	public Bird() {
	}

	public Bird(int code, String name, boolean canSing) {
		super(code, name);
		this.canSing = canSing;
	}

	@Override
	public String toString() {
		return "Bird [canSing=" + canSing + "]";
	}
}
