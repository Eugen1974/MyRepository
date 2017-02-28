package jaxb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MainJAXB {

	public static final File FILE = new File("resources/books1.xml");
	public static final Charset CHAR_SET = Charset.forName("UTF-8");
	private static final JAXBContext CONTEXT;

	static {
		try {
			CONTEXT = JAXBContext.newInstance(jaxb.Books.class);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		writeInXML();
		System.out.println();
		readFromXML();
	}

	public static void writeInXML() throws JAXBException, FileNotFoundException {
		Books books = new Books(Arrays.asList(
				new Book(1, "Алёна", "Книга №1", 11.1F, LocalDate.parse("15.02.1974", XmlLocalDateAdapter.PATTERN)),
				new Book(2, "Дарья", "Книга №2", 22.2F, LocalDate.parse("16.03.1975", XmlLocalDateAdapter.PATTERN)),
				new Book(3, "Света", "Книга №3", 33.3F, LocalDate.parse("17.04.1976", XmlLocalDateAdapter.PATTERN))));

		Marshaller marshaller = CONTEXT.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // pretty
																		// output
		marshaller.marshal(books,
				new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(FILE)), CHAR_SET));
		marshaller.marshal(books, System.out);
	}

	public static void readFromXML() throws JAXBException, FileNotFoundException {
		Books books = (Books) CONTEXT.createUnmarshaller()
				.unmarshal(new InputStreamReader(new BufferedInputStream(new FileInputStream(FILE)), CHAR_SET));
		books.getBooks().forEach(System.out::println);
	}
}
