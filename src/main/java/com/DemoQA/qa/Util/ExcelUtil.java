package com.DemoQA.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.DemoQA.qa.Base.BaseTest;

public class ExcelUtil extends BaseTest {
	String sheetPath = "G:\\eclipse\\DemoQa\\TestData\\TestData1.xlsx";
    String sheetName = "Sheet1";
	

	
	@SuppressWarnings("resource")
	public static Object[][] getTestData(String sheetPath, String sheetName) throws InvalidFormatException {
		
		Object[][] data = null;
		
		try {
			FileInputStream file = new FileInputStream(sheetPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rows=sheet.getLastRowNum();
            int cols=sheet.getRow(0).getLastCellNum();
			
            data= new Object[rows][cols];
			
            for(int i=0; i < sheet.getLastRowNum(); i++) {
				for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;
		
	}
	
}
