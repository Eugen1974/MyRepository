package stax.write;

import java.nio.file.Files;

//http://www.vogella.com/tutorials/JavaXML/article.html#javastax_write
public class MainWriteStAX {

	public static void main(String[] args) throws Exception {
		MyStAXWriter.writeXML();
		System.out.println("created " + MyStAXWriter.FILE + " " + MyStAXWriter.FILE.length()
				+ " bytes\n-------------------------------------");
		Files.readAllLines(MyStAXWriter.FILE.toPath()).forEach(System.out::println);
	}
}
