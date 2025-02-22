package com.myAutomation.dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	
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
	public Object[][] loginData(){
		
		Object[][] data = new Object[2][3];
		
		//1st set of data
		data[0][0] = "valid";
		data[0][1] = "n130547rguktn@gmail.com";
		data[0][2] = "Hyder#584";
		//2nd set of data
		data[1][0] = "invalid";
		data[1][1] = "Johnwick@gmail.com";
		data[1][2] = "abcdefg#123";
		
		return data;
	}
	
	
	
	
	
	
}
