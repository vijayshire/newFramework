package pkjTestCasesClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	int i = 1;

	@Test
	public void f() {

		System.out.println("I am Test..." + i);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am Before Test..." + i);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am Before Class..." + i);

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite..." + i);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am Before method..." + i);
	}
}
