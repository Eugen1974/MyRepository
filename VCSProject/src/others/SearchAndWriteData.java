package others;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchAndWriteData {

	public static final List<Integer> NUMBERS_SHOPS = Arrays.asList(10, 20, 50, 72);
	public static final File FILE_IN = new File("./resources/inData.xlsx");
	public static final File FILE_OUT = new File("./resources/outData.xlsx");
	public static final int AMOUNT_ROWS_IN_HEAD = 3;
	public static final int AMOUNT_COLUMNS = 19;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		searchAndWriteData();
		Runtime.getRuntime().exec("cmd /c start excel " + FILE_OUT.getCanonicalPath());
	}

	public static void searchAndWriteData() throws InvalidFormatException, IOException {
		try (Workbook workbookIn = new XSSFWorkbook(FILE_IN); Workbook workbookOut = new XSSFWorkbook()) {
			Sheet sheetIn = workbookIn.getSheetAt(0);
			Sheet sheetOut = workbookOut.createSheet("1-й Лист");

			copyRow(sheetIn.getRow(0), sheetOut);
			sheetOut.createRow(1);
			copyRow(sheetIn.getRow(2), sheetOut);
			sheetOut.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

			sheetIn.forEach(rowIn -> {
				if (rowIn.getRowNum() >= AMOUNT_ROWS_IN_HEAD) {
					if (NUMBERS_SHOPS.stream().anyMatch(num -> num == rowIn.getCell(0).getNumericCellValue())) {
						copyRow(rowIn, sheetOut);
					}
				}
			});

			for (int i = 0; i < AMOUNT_COLUMNS; i++) {
				sheetOut.autoSizeColumn(i);
			}

			workbookOut.write(new FileOutputStream(FILE_OUT));
		}
	}

	public static void copyRow(Row rowIn, Sheet sheetOut) {
		int rowNumIn = rowIn.getRowNum();
		int rowNumOut = rowNumIn < AMOUNT_ROWS_IN_HEAD ? rowNumIn : sheetOut.getLastRowNum() + 1;
		Row rowOut = sheetOut.createRow(rowNumOut);
		for (int numCell = 0; numCell < AMOUNT_COLUMNS; numCell++) {
			Cell cellIn = rowIn.getCell(numCell);
			Cell cellOut = rowOut.createCell(numCell);
			if (Objects.nonNull(cellIn)) {
				CellType cellType = cellIn.getCellTypeEnum();
				if (cellType == CellType.BLANK) {
				} else if (cellType == CellType.NUMERIC) {
					cellOut.setCellValue(cellIn.getNumericCellValue());
				} else if (Objects.equals(cellType, CellType.STRING)) {
					cellOut.setCellValue(cellIn.getStringCellValue());
				} else {
					throw new RuntimeException("Don't operated case for cellType = " + cellType.name() + " !");
				}
				CellStyle cellStyle = sheetOut.getWorkbook().createCellStyle();
				cellStyle.cloneStyleFrom(cellIn.getCellStyle());
				cellOut.setCellStyle(cellStyle);
			}
		}
	}
}
