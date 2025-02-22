package com.myAutomation.tests;

import org.testng.annotations.Test;

public class firstTestNGclass 
{

	@Test(priority = 1)
	public void openBrowser() 
	{
		System.out.println("open Browser");
	}
	
	@Test
	public void launchApplication() 
	{
		System.out.println("launch Application");
	}
	
	@Test(priority = 2)
	public void enterUsername() 
	{
		System.out.println("enter username");
	}
	
	@Test(priority = 4)
	public void enterPassword() 
	{
		System.out.println("enter password");
	}
	
	@Test(priority = 3)
	public void clickLoginBtn() 
	{
		System.out.println("click login button");
	}
	
	@Test(priority = 0)
	public void verifyLogin() 
	{
		System.out.println("verify login");
	}
	
	
}
