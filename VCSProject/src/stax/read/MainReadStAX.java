package stax.read;

//http://www.vogella.com/tutorials/JavaXML/article.html#javastax_read
public class MainReadStAX {

	public static void main(String[] args) {
		MyStAXReader.readData("resources/data.xml").forEach(System.out::println);
	}
}
