package others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class MainCompareTwoDirectories {

	public static void main(String[] args) throws IOException {
		compareFiles(Paths.get("//KRR-FPS07/SHARES$/ARM/SIT/Esaulov"));
		System.out.println("-----------\nDone");
	}

	public static void compareFiles(Path directory) throws IOException {
		if (!Files.isDirectory(directory)) {
			throw new IllegalArgumentException(directory.toString() + " does not directory !");
		}
		Files.list(directory).forEach(element -> {
			try {
				if (Files.isDirectory(element)) {
					compareFiles(element);
				} else {
					if (!element.getFileName().toString().endsWith(".log")) {
						// removing //KRR-FPS07/SHARES$/ARM/SIT
						String nameFile = "d:" + element.toString().substring(27);
						BasicFileAttributes attr1 = Files.readAttributes(element, BasicFileAttributes.class);
						BasicFileAttributes attr2 = Files.readAttributes(Paths.get(nameFile),
								BasicFileAttributes.class);
						if (!Objects.equals(attr1.lastModifiedTime(), attr2.lastModifiedTime())
								|| attr1.size() != attr2.size()) {
							System.out.println(nameFile);
						}
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		});
	}
}
