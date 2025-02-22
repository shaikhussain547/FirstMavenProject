package practiceSessions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before method");
	}
	@AfterTest
	public void tearDown() {
		System.out.println("After method");
	}
}
