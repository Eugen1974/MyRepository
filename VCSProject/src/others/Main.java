package others;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static final String NAME_FILE = "d:\\my.bin";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serialization();
		deserialization();
	}

	public static void serialization() throws FileNotFoundException, IOException {
		String str = "АБС";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
		out.writeObject(str);
		out.flush();
		out.close();
	}

	public static void deserialization() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(NAME_FILE));
		String str = (String) in.readObject();
		in.close();
		System.out.println(str);
	}
}
