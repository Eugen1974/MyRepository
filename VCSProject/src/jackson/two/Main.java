package jackson.two;

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
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
	private static final ObjectMapper PARSER;
	private static final String NAME_FILE;

	static {
		PARSER = new ObjectMapper();
		PARSER.configure(SerializationFeature.INDENT_OUTPUT, true); // pretty
																	// print
		NAME_FILE = "d:\\animals.json";
	}

	public static void main(String[] args) throws IOException {
		writeJson();
		readJson().animals.forEach(ob -> System.out.print("\ncode=" + ob.code + " name=" + ob.name + " " + ob));
	}

	public static void writeJson() throws IOException {
		Animals animals = new Animals(
				Arrays.asList(new Cat(1, "cat", "black"), new Fish(2, "fish", 11.1F), new Bird(3, "bird", true)));
		try (Writer out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			PARSER.writeValue(out, animals);
		}
		System.out.println(PARSER.writeValueAsString(animals));
	}

	public static Animals readJson() throws IOException {
		try (Reader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			return PARSER.readValue(in, Animals.class);
		}
	}
}
