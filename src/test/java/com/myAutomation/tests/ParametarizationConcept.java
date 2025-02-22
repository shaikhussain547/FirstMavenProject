package com.myAutomation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametarizationConcept {
	WebDriver driver;
	String FFKey = "webdriver.gecko.driver";
	String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
	
	@Parameters("browser")
	@Test
	public void openBrowser(String webBrowser) 
	{
		System.out.println("open Browser");
		String browser = webBrowser.toUpperCase();
		if(browser.equals("CHROME")) {
			driver = new ChromeDriver();
		}else if(browser.equals("FIREFOX")){
			driver = new FirefoxDriver();
			System.setProperty(FFKey, FFValue);
		}else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@Parameters("appUrl")
	@Test
	public void launchApplication(String url) 
	{
		System.out.println("launch Application");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Parameters({"username","password"})
	@Test
	public void enterCredentials(String username, String password) 
	{
		System.out.println("enter credentials");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}
	
	@Test
	public void clickLoginBtn() 
	{
		System.out.println("click login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test
	public void verifyLogin() throws InterruptedException 
	{
		System.out.println("verify login");
		WebElement header = driver.findElement(By.xpath("//h1[@class='page-header']"));
		System.out.println(header.getText());
		Thread.sleep(2000);
		driver.close();
	}
	
}
