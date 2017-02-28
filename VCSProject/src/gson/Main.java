package gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static final String NAME_FILE = "resources/persons.json";
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	public static final Gson PARSER = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) throws IOException {
		writeJSON();
		System.out.println("\n" + readJSON());
	}

	public static void writeJSON() throws IOException {
		Persons persons = new Persons(Arrays.asList(new Person(1, "Петя", LocalDate.parse("10.05.2010", FORMATTER)),
				new Person(2, "Вася", LocalDate.parse("11.06.2011", FORMATTER)),
				new Person(3, "Женя", LocalDate.parse("12.07.2012", FORMATTER))));

		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			PARSER.toJson(persons, Persons.class, writer);
		}

		Files.lines(new File(NAME_FILE).toPath(), StandardCharsets.UTF_8).forEach(System.out::println);
	}

	public static Persons readJSON() throws IOException {
		try (Reader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(NAME_FILE), StandardCharsets.UTF_8))) {
			return PARSER.fromJson(reader, Persons.class);
		}
	}
}