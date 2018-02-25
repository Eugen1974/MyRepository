package others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkWith_XLSX_File {

	public static final int AMOUNT_ROWS = 5;
	public static final int AMOUNT_COLUMNS = 3;

	public static void main(String[] args) throws IOException {
		File file = File.createTempFile("eugen", ".xlsx");
		writeToExcel(file);
		System.out.println();
		readFromExcel_1(file);
		System.out.println();
		readFromExcel_2(file);
		Runtime.getRuntime().exec("cmd /c start excel " + file.getCanonicalPath());
	}

	public static void readFromExcel_1(File file) throws IOException {
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
			workbook.forEach(sheet -> {
				sheet.forEach(row -> {
					row.forEach(cell -> {
						if (cell.getCellTypeEnum() == CellType.STRING) {
							System.out.print(cell.getStringCellValue() + " ");
						} else {
							System.out.print(cell.getNumericCellValue() + " ");
						}
					});
					if (row.getRowNum() == 0) {
						System.out.println("\n------------");
					} else {
						System.out.println();
					}
				});
			});
		}
	}

	public static void readFromExcel_2(File file) throws IOException {
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
			workbook.forEach(sheet -> {
				sheet.forEach(row -> {
					row.forEach(cell -> {
						CellReference cellReference = new CellReference(cell.getRowIndex(), cell.getColumnIndex());
						String nameCell = cellReference.formatAsString();
						if (cell.getCellTypeEnum() == CellType.STRING) {
							System.out.print(nameCell + " = " + cell.getStringCellValue() + "  ");
						} else {
							System.out.print(nameCell + " = " + cell.getNumericCellValue() + "  ");
						}
					});
					System.out.println();
				});
			});
		}

	}

	public static void writeToExcel(File file) throws IOException {
		try (Workbook workbook = new XSSFWorkbook()) {

			Font fontRed = workbook.createFont();
			fontRed.setFontName("Times New Roman");
			fontRed.setColor(Font.COLOR_RED);
			fontRed.setBold(true);
			fontRed.setFontHeightInPoints((short) 12);

			CellStyle styleRed = workbook.createCellStyle();
			styleRed.setAlignment(HorizontalAlignment.CENTER);
			styleRed.setFont(fontRed);

			CellStyle styleCommon = workbook.createCellStyle();
			styleCommon.setAlignment(HorizontalAlignment.CENTER);

			Sheet sheet = workbook.createSheet("Мой лист");
			int counter = 0;
			for (int indexRow = 0; indexRow < AMOUNT_ROWS; indexRow++) {
				Row row = sheet.createRow(indexRow);
				for (int indexColumn = 0; indexColumn < AMOUNT_COLUMNS; indexColumn++) {
					if (indexRow == 0) {
						Cell cell = row.createCell(indexColumn, CellType.STRING);
						if (indexColumn == 0) {
							cell.setCellValue("AAA");
						} else if (indexColumn == 1) {
							cell.setCellValue("BBBBBBBBBBBB");
						} else {
							cell.setCellValue("CCC");
						}
						cell.setCellStyle(styleRed);
					} else {
						Cell cell = row.createCell(indexColumn, CellType.NUMERIC);
						if (indexRow == (AMOUNT_ROWS - 1)) { // last row
							if (indexColumn == 0) {
								cell.setCellFormula("SUM(A2:A4)");
							} else if (indexColumn == 1) {
								cell.setCellFormula("SUM(B2:B4)");
							} else {
								cell.setCellFormula("SUM(C2:C4)");
							}
							cell.setCellStyle(styleRed);
						} else {
							cell.setCellValue((double) ++counter);
							cell.setCellStyle(styleCommon);
						}
					}
				}
			}
			for (int indexColumn = 0; indexColumn < AMOUNT_COLUMNS; indexColumn++) {
				sheet.autoSizeColumn(indexColumn);
			}
			Sheet sheet2 = workbook.createSheet(WorkbookUtil.createSafeSheetName("@#$%^&*(\")_"));
			System.out.println("safe sheet's name is " + sheet2.getSheetName() + "\n");

			workbook.write(new FileOutputStream(file));
			System.out.println(file.getCanonicalPath() + " is created");
		}
	}
}
