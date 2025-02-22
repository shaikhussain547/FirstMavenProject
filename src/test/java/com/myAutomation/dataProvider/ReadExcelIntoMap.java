package com.myAutomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelIntoMap {
	
	public static Workbook book;
	public static  Sheet sheet;

	public static void main(String[] args) {
		
		String configFilePath = ".\\src\\test\\resources\\TestData\\Tdata.xlsx";
		FileInputStream file = null;
		try {
			file = new FileInputStream(configFilePath);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet("Config");
		System.out.println(sheet.getLastRowNum()); //4
		
		HashMap<String, String> configMap = new HashMap<String, String>();
		
		
		/**Read excel sheet*/
		int k = 0;
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			String name = sheet.getRow(i+1).getCell(k).toString().trim();
			String value = sheet.getRow(i+1).getCell(k+1).toString().trim();
			//Storing values into hashmap:
			configMap.put(name, value);
		}
		
		System.out.println(configMap.get("Tom")); //SDET
		System.out.println(configMap.get("John")); //QA
		
		
		
		
		
		
	}

}
