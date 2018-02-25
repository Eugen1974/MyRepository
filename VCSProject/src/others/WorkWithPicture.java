package others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkWithPicture {

	public static void main(String[] args) throws IOException {
		File file = File.createTempFile("picture", ".xlsx");
		writePicture(file);
		Runtime.getRuntime().exec("cmd /c start excel " + file.getCanonicalPath());
	}

	public static void writePicture(File file) throws IOException {
		try (Workbook workbook = new XSSFWorkbook()) {

			byte[] bytes = IOUtils.toByteArray(new FileInputStream("./resources/Брайан_Трейси.jpg"));
			int indexPicture = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

			Sheet sheet = workbook.createSheet("1-й Лист");

			Drawing<?> drawing = sheet.createDrawingPatriarch();

			CreationHelper helper = workbook.getCreationHelper();
			ClientAnchor anchor = helper.createClientAnchor();
			anchor.setCol1(1);
			anchor.setRow1(1);

			Picture pict = drawing.createPicture(anchor, indexPicture);
			pict.resize(12, 20);

			workbook.write(new FileOutputStream(file));
			System.out.println(file.getCanonicalPath() + " is created");
		}
	}
}
