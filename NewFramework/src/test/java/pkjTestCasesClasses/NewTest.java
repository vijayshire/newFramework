package pkjTestCasesClasses;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest extends RemoteWebDriver {

	int i = 1;

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		WebDriver driver1 = new ChromeDriver();
		ChromeDriver driver2 = new ChromeDriver();

		System.out.println("I am Test..." + i);
		driver1.get("https://www.google.com");
		driver.get("https://www.google.com");

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
