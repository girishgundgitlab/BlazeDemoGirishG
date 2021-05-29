package com.blazedemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingUtility {

	public static Object[][] readData(String sheetName) throws IOException {
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\blazedemo\\xcel\\Demo.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(ip);
		XSSFSheet sh=wb.getSheet(sheetName);
		
		//store the data into 2D object array

		int totolRows=sh.getPhysicalNumberOfRows();
		
		int totalCols=sh.getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][]=new Object[totolRows-1][totalCols];
		
		for(int i=1;i<totolRows;i++) {
			for(int j=0;j<totalCols;j++) {
				arr[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return arr;
		
		
		
		
		
		
	}
}
