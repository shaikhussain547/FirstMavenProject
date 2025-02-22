package com.myAutomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		
//		String filePath = "C:\\Users\\hussa\\eclipse-workspace\\FirstMavenProject\\src\\test\\resources\\TestData\\Tdata.xlsx";
//		File file = new File(".\\src\\test\\resources\\TestData\\Tdata.xlsx");
//		FileInputStream fi = new FileInputStream(file);
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData\\Tdata.xlsx");
		//Apache POI Library
		XSSFWorkbook wb = new XSSFWorkbook(fi);		
//		wb.getSheetAt(0);
		XSSFSheet sheet = wb.getSheet("LoginCreds");
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("Rows count: "+rows);
//		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		int columns = sheet.getRow(0).getLastCellNum();
		System.out.println(columns);
		
		for(int row=1; row < rows; row++) {
			for(int col=0; col < columns; col++) {
				String cellData = sheet.getRow(row).getCell(col).getStringCellValue();
				System.out.print(cellData+" ");
			}
			System.out.println();
		}
		
		wb.close();		
	}

}
