package com.envision.core.components;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name = "testCaseDataProvider")
	public static Object[][] getTestScenarioData(Method m)
			throws InvalidFormatException, IOException {

		List<List<String>> testCaseData = new ArrayList<List<String>>();
		String testCaseName = m.getName(); // "loginScenario"
		File excelFile = new File(System.getProperty("user.dir")
				+ "//src//test//resources//testdata//" + "TestDataSheet.xlsx");
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheet(System.getProperty("envName").toUpperCase());
		// Sheet sheet = workbook.getSheet("STAGING");
		int noOfRows = sheet.getPhysicalNumberOfRows();

		List<String> testDataSet;
		for (int i = 0; i < noOfRows; i++) {
			// iterate through all the rows
			testDataSet = new ArrayList<String>();
			Row row = sheet.getRow(i);
			String testExcelTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
			String testDataColumns = "";
			if (testExcelTestCaseName.equalsIgnoreCase(testCaseName)) {
				testDataColumns = sheet.getRow(i).getCell(1).getStringCellValue();
				String[] testDataFields = testDataColumns.split(",");
				int fields = testDataFields.length;
				for (int j = 0; j < fields; j++) {
					int index = getIndexForColumn(sheet.getRow(0), testDataFields[j]);
					testDataSet.add(row.getCell(index).getStringCellValue());
				}
				testCaseData.add(testDataSet);
				testDataSet = null;
			}
		}
		return parseListToObjectArray(testCaseData);
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * DataProviderUtils.getTestScenarioData("loginScenario"); }
	 */

	public static String getCellValue(Cell cell) {
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BLANK) {
			return "";
		}
		return null;
	}

	public static int getIndexForColumn(Row row, String column) {
		int noOfCols = row.getPhysicalNumberOfCells();

		for (int i = 0; i < noOfCols; i++) {
			Cell cell = row.getCell(i);
			String columnName = getCellValue(cell);
			if (columnName.equalsIgnoreCase(column)) {
				return i;
			}
		}
		return -1;
	}

	public static Object[][] parseListToObjectArray(List<List<String>> testData) {
		Object[][] TwoDArray = new Object[testData.size()][testData.get(0).size()];
		for (int i = 0; i < testData.size(); i++) {
			List<String> subset = testData.get(i);
			for (int j = 0; j < subset.size(); j++) {
				TwoDArray[i][j] = subset.get(j);
			}
		}
		return TwoDArray;
	}

}
