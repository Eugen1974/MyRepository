package others;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main1 {
	public static final FileInputStream IN_FILE = getInFile();
	public static final FileOutputStream OUT_FILE = getOutFile();
	public static final List<Integer> LIST = new LinkedList<>();

	public static FileInputStream getInFile() {
		try {
			return new FileInputStream("resources/txt/a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}

	public static FileOutputStream getOutFile() {
		try {
			return new FileOutputStream("resources/txt/b.txt");
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
			LIST.add(b);
		}
	}

	public static void writeFile() throws IOException {
		for (int position = LIST.size() - 1; position >= 0; position--) {
			Integer data = LIST.get(position);
			if (data != 10) { // Enter
				OUT_FILE.write(data);
			}
		}
	}

	public static void closeFile() throws IOException {
		IN_FILE.close();
		OUT_FILE.close();
	}
}
