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

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;

	public Object[][] getData(String testCaseName) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\vijay\\git\\newFramework\\NewFramework\\TestData.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("sheet1");
		String strTestCaseName = testCaseName;
		int totalRows;
		int testRows;
		int totalColumn;

		return null;

	}

	public int getTotalRows(XSSFSheet sheet) {
		int totalRows = sheet.getLastRowNum();

		for (int i = 0; i < totalRows; i++) {
			if (sheet.getRow(i).getCell(0).getRawValue().isEmpty()) {

			}
		}
		return 0;

	}
}
