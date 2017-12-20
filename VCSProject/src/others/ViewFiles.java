package others;

import java.io.File;
import java.io.IOException;

public class ViewFiles {

	public static void main(String[] args) throws IOException {
		for (File file : new File("./resources").listFiles()) {
			String nameFile = file.getName().toLowerCase();
			String command = "";
			if (nameFile.endsWith(".pdf")) {
				command = "start AcroRd32 ";
			} else if (nameFile.endsWith(".xls") || nameFile.endsWith(".xlsx")) {
				command = "start Excel ";
			} else if (nameFile.endsWith(".doc") || nameFile.endsWith(".docx")) {
				command = "start Winword ";
			} else if (nameFile.endsWith(".txt")) {
				command = "start Notepad ";
			}
			Runtime.getRuntime().exec("cmd /c " + command + file.getCanonicalPath());
		}
	}
}
