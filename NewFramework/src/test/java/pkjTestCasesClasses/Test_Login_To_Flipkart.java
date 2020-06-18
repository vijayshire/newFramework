package pkjTestCasesClasses;

import org.testng.annotations.Test;

import pkjConfigClasses.Config;
import pkjFunctionsClasses.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Test_Login_To_Flipkart {

	Config objConfig = new Config();
	LoginPage objLoginPage = new LoginPage();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@Test
	public void login() throws IOException {
		driver.get().get("https://www.flipkart.com");
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		Assert.assertEquals(objLoginPage.txtBoxUserName(driver.get(), "9158833338"), true,
				"Error in inserting username");
		Assert.assertEquals(objLoginPage.txtBoxPassword(driver.get(), "Success@1816"), true,
				"Error in inserting Password");
		Assert.assertEquals(objLoginPage.btnLogin(driver.get()), true, "Error in clicking Login button");

	}

	@BeforeClass
	@Parameters({ "Browser" })
	public void beforeTest(String browser) {
		driver.set(objConfig.mthdBeforeTest(this.getClass().getSimpleName(), browser));
		System.out.println("Before Method executed ");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite...of test 2");
		objConfig.mthdBeforeSuite();

	}

	@AfterClass
	public void afterTest() {
		objConfig.mthdAfterTest(driver.get());

	}

	@AfterSuite
	public void afterSuite() {

		objConfig.mthdAfterSuite();

	}
}
