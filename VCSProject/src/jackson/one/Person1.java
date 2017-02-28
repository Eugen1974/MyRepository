package jackson.one;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Person1 {
	@JsonProperty
	private int id;
	@JsonProperty
	private String name;
	@JsonDeserialize(using = JacksonLocalDateDeserializer.class)
	@JsonSerialize(using = JacksonLocalDateSerializer.class)
	private LocalDate bithDay;

	public Person1() {
	}

	public Person1(int id, String name, LocalDate bithDay) {
		this.id = id;
		this.name = name;
		this.bithDay = bithDay;
	}

	@Override
	public String toString() {
		return "Person1 [id=" + id + ", name=" + name + ", bithDay=" + bithDay + "]";
	}
}
