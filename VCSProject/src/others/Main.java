package others;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

	static final String NAME_FILE = "./resources/EnglishWords.txt";
	static final String CHARSET_NAME = "UTF-8";

	public static void main(String[] args) {
		f1();
		f2();
	}

	public static void f1() {
		char[] array = new char[5];
		Reader in = null;
		try {
			in = new InputStreamReader(new FileInputStream(NAME_FILE), CHARSET_NAME);
			in.read(array);
			System.out.println(array);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void f2() {
		char[] array = new char[5];
		try (Reader in = new InputStreamReader(new FileInputStream(NAME_FILE), CHARSET_NAME)) {
			in.read(array);
			System.out.println(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}