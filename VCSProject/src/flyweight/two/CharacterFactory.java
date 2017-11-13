package flyweight.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CharacterFactory {

	private static final Map<Integer, AbstractCharacter> CHARACTERS;

	static {
		CHARACTERS = new HashMap<>();
	}

	private CharacterFactory() {
	}

	public static AbstractCharacter getCharacter(int numCharacter) {
		AbstractCharacter character = CHARACTERS.get(numCharacter);
		if (Objects.isNull(character)) {
			if (numCharacter == 0) {
				character = new CharacterA();
			} else if (numCharacter == 1) {
				character = new CharacterB();
			} else if (numCharacter == 2) {
				character = new CharacterC();
			} else {
				throw new IllegalArgumentException("Doesn't operated case for numCharacter = " + numCharacter + " !");
			}
			CHARACTERS.put(numCharacter, character);
		}
		return character;
	}
}
