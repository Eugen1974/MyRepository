package others;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class Main1 {
	public static final String ENCODING = "UTF-8";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		readStr();
		writeStr();
	}

	public static void readStr() throws FileNotFoundException, IOException {
		String str = "АБС";
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(Main.NAME_FILE),
				Charset.forName(ENCODING));
		out.write(str);
		out.flush();
		out.close();
	}

	public static void writeStr() throws FileNotFoundException, IOException, ClassNotFoundException {
		InputStreamReader in = new InputStreamReader(new FileInputStream(Main.NAME_FILE), Charset.forName(ENCODING));
		for (int i = in.read(); i != -1; i = in.read()) {
			System.out.print((char) i);
		}
		in.close();
	}
}
