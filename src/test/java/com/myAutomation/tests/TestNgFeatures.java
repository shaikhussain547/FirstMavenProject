package com.myAutomation.tests;

import org.testng.annotations.Test;

public class TestNgFeatures {

	@Test
	public void loginTest() {
		System.out.println("login test");
//		int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("home page test");
	}
	
	
	
	
}
