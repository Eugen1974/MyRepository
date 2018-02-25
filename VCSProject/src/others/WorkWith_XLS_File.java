package others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkWith_XLS_File {

	public static void main(String[] args) throws IOException {
		File file = File.createTempFile("eugen", ".xls");
		writeToExcel(file);
		readFromExcel(file);
		Runtime.getRuntime().exec("cmd /c start excel " + file.getCanonicalPath());
	}

	public static void readFromExcel(File file) throws IOException {
		try (Workbook workbook = new HSSFWorkbook(new FileInputStream(file))) {
			workbook.forEach(sheet -> {
				sheet.forEach(row -> {
					row.forEach(cell -> {
						System.out.println("\nrowIndex = " + cell.getRowIndex() + ", columnIndex = "
								+ cell.getColumnIndex() + ", cellValue = " + cell.getStringCellValue());
					});
				});
			});
		}
	}

	public static void writeToExcel(File file) throws IOException {
		try (Workbook workbook = new HSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("1-й лист");
			Row row = sheet.createRow(1);
			int numColumn = 2;
			Cell cell = row.createCell(numColumn, CellType.STRING);
			cell.setCellValue("Привет Женя !");
			sheet.autoSizeColumn(numColumn);

			workbook.write(new FileOutputStream(file));
			System.out.println(file.getCanonicalPath() + " is created");
		}
	}
}
