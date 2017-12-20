package others;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchStringInFile {

	public static void main(String[] args) throws IOException {

		Path path = new File("z:\\MRC\\OLGA\\ARM_SEKRETAR_LMZ\\OKNO_PRIVET.fmb").toPath();

		// Determine the encoding of the file - when trying to read, there is no error
		// java.nio.charset.MalformedInputException
/*
		Charset.availableCharsets().forEach((nameCharSet, charSet) -> {
			try {
				Files.readAllLines(path, charSet);
				System.out.println(charSet);
			} catch (IOException e) {
			}
		});
*/
		// Use any suitable encoding
		Files.readAllLines(path, Charset.forName("windows-1256")).forEach(line -> {
			if (line.toLowerCase().contains(":global.")) {
				System.out.println(line);
			}
		});
	}
}
