package com.myAutomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3 {
	
	
	@Test(dataProvider = "loginCredentials")
	public void acmeLogin(String testType,String uname, String pwd) throws InterruptedException {
		System.out.println("Acme-test uipath login");
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(testType.equals("valid")) {
			WebElement header = driver.findElement(By.xpath("//h1[@class='page-header']"));
			System.out.println(header.getText());
			Assert.assertEquals(header.getText(), "Dashboard", "Label text is not matching");
			Thread.sleep(2000);
			driver.findElement(By.linkText("Log Out")).click();
		}else {
			System.out.println("Invalid credentials entered");
			Thread.sleep(2000);
		}
		driver.close();
	}
	
	@DataProvider(name = "loginCredentials")
	public Object[][] loginData() throws Exception{
		
		Object[][] data = new Object[2][3];
		
		File file = new File(".\\src\\test\\resources\\TestData\\Tdata.xlsx");
		FileInputStream fi = new FileInputStream(file);
		//Apache POI Library
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet("LoginCreds");
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("Rows count: "+rows);
		int columns = sheet.getRow(0).getLastCellNum();
		System.out.println(columns);
		
		for(int row=0; row < rows-1; row++) {
			for(int col=0; col < columns; col++) {
				data[row][col] = sheet.getRow(row+1).getCell(col).getStringCellValue();
			}
			System.out.println();
		}
		
		wb.close();
		
		return data;
	}
	
	
	
	
	
	
}
