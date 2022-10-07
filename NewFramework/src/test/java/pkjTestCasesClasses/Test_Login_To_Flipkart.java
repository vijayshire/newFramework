package pkjTestCasesClasses;

import org.testng.annotations.Test;

import pkjConfigClasses.Config;
import pkjFunctionsClasses.LoginPage;
import pkjUtilityClasses.TestData;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
	private TestData objTestData1 = new TestData();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@Test(dataProvider = "getData")
	public void login(String userName, String passWord) throws IOException {

		Assert.assertEquals(objLoginPage.txtBoxUserName(driver.get(), userName), true, "Error in inserting username");
		Assert.assertEquals(objLoginPage.txtBoxPassword(driver.get(), passWord), true, "Error in inserting Password");
		Assert.assertEquals(objLoginPage.btnLogin(driver.get()), true, "Error in clicking Login button");

	}

	@BeforeTest
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

	@AfterTest
	public void afterTest() {
		objConfig.mthdAfterTest(driver.get());

	}

	@AfterSuite
	public void afterSuite() {

		objConfig.mthdAfterSuite();

	}

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {

		Object[][] test = objTestData1.getData(this.getClass().getSimpleName());

		return test;
	}
}
