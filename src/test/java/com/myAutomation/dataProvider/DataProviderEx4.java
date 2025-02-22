package com.myAutomation.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx4 {
	
	@DataProvider(name="loginCredentials")
	public String[][] allData(){
		
		String filePath = ".\\src\\test\\resources\\TestData\\Tdata.xlsx";
		String sheetName = "LoginCreds";
		
		int rowsCount = ReadExcelPart3.getRowCount(filePath, sheetName);
	//	System.out.println(rowsCount);
		
		int colCount = ReadExcelPart3.getColCount(filePath, sheetName);
	//	System.out.println(colCount);
		
		String[][] credsData = new String[rowsCount-1][colCount];
		for(int row=1; row<rowsCount; row++) {
			for(int col=0; col<colCount; col++) {
				credsData[row-1][col] = ReadExcelPart3.getCellValue(filePath, sheetName, row, col);
	//			System.out.print(credsData[row][col]+", ");
			}
			System.out.println();
		}
		
		return credsData;
	}
	
	@Test(dataProvider = "loginCredentials")
	public void test(String type, String uname, String pwd) {
		System.out.println(type+", "+uname+", "+pwd);
	}
		


}
