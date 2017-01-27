package others;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] array = "Привет Hello".getBytes();

		String[] charSets = { "UTF-8", "UTF-16", "UTF-32", "windows-1251", "x-MacUkraine", "KOI8-R", "KOI8-U",
				"US-ASCII", "Unicode" };

		for (String charSet : charSets) {
			System.out.println(String.format("%12s: %s", charSet, new String(array, charSet)));
		}
		System.out.println("\ndefaultCharset=" + Charset.defaultCharset() + "\n");

		Charset.availableCharsets().forEach(
				(key, value) -> System.out.println(String.format("%20s: %s", value, new String(array, value))));
	}
}