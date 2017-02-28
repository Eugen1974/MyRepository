package jackson.two;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Cat.class), 
				@Type(value = Fish.class), 
				@Type(value = Bird.class) })
public abstract class Animal {
	@JsonProperty
	protected int code;
	@JsonProperty
	protected String name;

	public Animal() {
	}

	public Animal(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
