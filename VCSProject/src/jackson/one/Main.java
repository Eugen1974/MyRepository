package jackson.one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {

	private static final ObjectMapper PARSER;
	public static final String NAME_FILE;

	static {
		PARSER = new ObjectMapper();
		PARSER.configure(SerializationFeature.INDENT_OUTPUT, true); // pretty
																	// output
		NAME_FILE = "d:\\a.json";
	}

	public static void main(String[] args) throws IOException {
		writeJson();
		readJson().forEach(System.out::println);
	}

	public static void writeJson() throws IOException {
		try (Writer out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			List<Person1> person = Arrays.asList(new Person1(1, "AAA", LocalDate.now().plusMonths(1)),
					new Person1(2, "BBB", LocalDate.now().plusMonths(2)),
					new Person1(3, "CCC", LocalDate.now().plusMonths(3)));
			PARSER.writeValue(out, person);
		}
	}

	public static List<Person1> readJson() throws IOException {
		try (Reader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			List<Person1> persons = PARSER.readValue(in, new TypeReference<List<Person1>>() {
			});
			return persons;
		}
	}
}
