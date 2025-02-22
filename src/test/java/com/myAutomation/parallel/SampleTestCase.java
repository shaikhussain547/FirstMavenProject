package com.myAutomation.parallel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleTestCase {
	
	@Test
	public void acmeLogin() throws InterruptedException {
		System.out.println("Acme-test uipath login");
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("n130547rguktn@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hyder#584");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement header = driver.findElement(By.xpath("//h1[@class='page-header']"));
		System.out.println(header.getText());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}
	
	@Test
	public void swagLogin() throws InterruptedException {
		System.out.println("Swag login");
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(2000);
		//Handling alert
		boolean alertHandledSuccessfully = false;
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        	wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert is present");
            Alert alert = driver.switchTo().alert();
            alertHandledSuccessfully = true;
            if(alertHandledSuccessfully) {
            	alert.accept();
            }
        } catch(Exception e) {
            System.out.println("Timed out (5 seconds) waiting for alert to be present");
        }
		WebElement header = driver.findElement(By.xpath("//div[@class='app_logo']"));
		System.out.println(header.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		driver.quit();
	}
	
	
	
	
}
