package others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
	public static final RandomAccessFile IN_FILE = getFile("resources/txt/a.txt", "r");
	public static final RandomAccessFile OUT_FILE = getFile("resources/txt/b.txt", "rw");

	public static RandomAccessFile getFile(String name, String mode) {
		try {
			return new RandomAccessFile(name, mode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		readFile();
		writeFile();
		closeFile();
	}

	public static void readFile() throws IOException {
		for (int b = IN_FILE.read(); b != -1; b = IN_FILE.read()) {
			System.out.print((char) b);
		}
	}

	public static void writeFile() throws IOException {
		for (long position = IN_FILE.length(); position >= 0; position--) {
			IN_FILE.seek(position);
			int b = IN_FILE.read();
			if (b != 10) { // Enter
				OUT_FILE.write(b);
			}
		}
	}

	public static void closeFile() throws IOException {
		IN_FILE.close();
		OUT_FILE.close();
	}
}
