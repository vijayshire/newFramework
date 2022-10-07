/*
-----------------------------------------------------------------------------------------------------
|	Developer	: 	Vijay Hire												 					 	 	
*	Project		: 	NewFramework																 
|	Location	: 	Pune																		 
*	Date		: 	2020-06-08											 
|	File		:	caller.java																 
*	Copyright (C) Abibue Tech - All Rights Reserved												 
|   		Unauthorized copying of this file, via any medium is strictly prohibited			 
*   		Proprietary and confidential														 
|  			Written by Vijay Hire <iamvijayhire@gmail.com>.
-----------------------------------------------------------------------------------------------------										 
*/

package pkjUtilityClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	public int startRowNum = 0;
	public int endRowNum = 0;
	int testRows = 0;
	int testColumn = 0;
	int rowCount = 0;
	String strTestCaseName;
	String strArray[][] = null;

	public synchronized Object[][] getData(String testCaseName) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\vijay\\git\\newFramework\\NewFramework\\TestData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("sheet1");
		strTestCaseName = testCaseName;
		getTotalRows(sheet);
		testRows(sheet, strTestCaseName);
		strArray = new String[testRows][testColumn - 1];

		for (int i = 0; i < testRows; i++) {

			System.out.println("I am Parent For loop I= " + i);

			for (int j = 0; j < testColumn - 1; j++) {
				if (sheet.getRow(startRowNum).getCell(j + 1).getCellTypeEnum() == CellType.STRING) {
					strArray[i][j] = sheet.getRow(startRowNum).getCell(j + 1).getStringCellValue();
					System.out.println("Value written in If ");
				} else {
					strArray[i][j] = String.valueOf(sheet.getRow(startRowNum).getCell(j + 1).getNumericCellValue());
					System.out.println("Value written in If ");
				}

				System.out.println("I am Child For loop j= " + strArray[i][j]);

			}

			startRowNum++;
		}

		System.out.println("Returning to Data Provider ");
		return strArray;

	}

	public void getTotalRows(XSSFSheet sheet) {

		System.out.println("I am Total Rows....");
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row rows = row.next();
			if (rows.getCell(0).getStringCellValue().isEmpty()) {
				System.out.println("Row : ");
				sheet.removeRow(rows);
			}

		}

		System.out.println("I am Total Rows...." + sheet.getLastRowNum());

	}

	public void testRows(XSSFSheet sheet, String strTestCaseName) {

		System.out.println("I am test rows...");

		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row rows = row.next();
			if (rows.getCell(0).getStringCellValue().trim().equalsIgnoreCase(strTestCaseName)) {
				getTestColumn(rows);
				if (startRowNum == 0) {
					startRowNum = rows.getCell(0).getRowIndex();
					rowCount++;
				} else {
					endRowNum = rows.getCell(0).getRowIndex();
					rowCount++;
				}

			}

		}

		testRows = rowCount;

		System.out.println("startRowNum= " + startRowNum);
		System.out.println("endRowNum= " + endRowNum);
		System.out.println("testRows= " + testRows);
	}

	public void getTestColumn(Row row) {

		System.out.println("I am testColumn...");

		Iterator<Cell> cell = row.iterator();
		while (cell.hasNext()) {
			Cell cells = cell.next();
			if (cells.getStringCellValue().isEmpty()) {
				row.removeCell(cells);

			}
		}
		testColumn = row.getLastCellNum();
		System.out.println("testcolumn= " + testColumn);
	}
}
