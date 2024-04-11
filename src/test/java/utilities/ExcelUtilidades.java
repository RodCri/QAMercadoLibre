package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtilidades {
	
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	
	public static Object[][] getTableArray(String filePath, String sheetName)throws Exception{
		String[][] tabArray = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = excelWSheet.getLastRowNum();
			int totalCols = excelWSheet.getRow(0).getPhysicalNumberOfCells();
			tabArray = new String[totalRows][totalCols];
			ci = 0;
			for(int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for(int j = startCol; j<= totalCols -1; j++,cj++) {
					tabArray[ci][cj] = getCellData(i,j);
					System.out.println(tabArray[ci][cj]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (tabArray);
	}
	
	public static String getCellData(int rowNum, int colNum) {
		cell = excelWSheet.getRow(rowNum).getCell(colNum);
		String cellData = "";
		if(cell.getCellType()==null) {
			return "";
		}else {
			try {
				cellData = cell.getStringCellValue();
			} catch (Exception e) {
				cellData = Double.toString(cell.getNumericCellValue()).split("\\. ")[0];
			}
		}
		return cellData;
	}
  @Test
  public void f() {
  }
}
