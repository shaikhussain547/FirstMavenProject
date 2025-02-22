package com.myAutomation.tests;

import org.testng.annotations.Test;
//smokeSuite.xml
public class Group_Ex2 {
	
	@Test(groups = {"smoke","regression"})
	public void test4() {
		System.out.println("Test Method 4");
	}
	
	@Test(groups = {"sanity","regression"})
	public void test5() {
		System.out.println("Test Method 5");
	}
	
	@Test(groups = "regression")
	public void test6() {
		System.out.println("Test Method 6");
	}
	
	
}
