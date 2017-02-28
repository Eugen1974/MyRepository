package jackson.one;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JacksonLocalDateSerializer extends JsonSerializer<LocalDate> {

	public static final DateTimeFormatter PATTERN_LOCAL_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.format(PATTERN_LOCAL_DATE));
	}
}
