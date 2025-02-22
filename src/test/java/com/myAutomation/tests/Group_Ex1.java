package com.myAutomation.tests;

import org.testng.annotations.Test;
//smokeSuite.xml
public class Group_Ex1 {
	
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("Test Method 1");
	}
	
	@Test(groups = "sanity")
	public void test2() {
		System.out.println("Test Method 2");
	}
	
	@Test(groups = "regression")
	public void test3() {
		System.out.println("Test Method 3");
	}
	
	
	
}
