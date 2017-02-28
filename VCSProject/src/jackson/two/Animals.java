package jackson.two;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animals {
	@JsonProperty
	protected List<Animal> animals;

	public Animals() {
		animals = new ArrayList<>();
	}

	public Animals(List<Animal> animals) {
		this.animals = animals;
	}
}
