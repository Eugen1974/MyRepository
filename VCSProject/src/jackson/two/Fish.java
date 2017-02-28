package jackson.two;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fish extends Animal {
	@JsonProperty
	protected float weight;

	public Fish() {
	}

	public Fish(int code, String name, float weight) {
		super(code, name);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Fish [weight=" + weight + "]";
	}
}
