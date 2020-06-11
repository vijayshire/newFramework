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

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Test_Check_Login_To_Flipkart {
	Config objConfig = new Config();
	LoginPage objLoginPage = new LoginPage();
	public WebDriver driver;

	@Test
	public void login() throws IOException {
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Assert.assertEquals(objLoginPage.txtBoxUserName(driver, "9158833338"), true, "Error in inserting username");
		Assert.assertEquals(objLoginPage.txtBoxPassword(driver, "Success@1816"), true, "Error in inserting Password");
		Assert.assertEquals(objLoginPage.btnLogin(driver), true, "Error in clicking Login button");
	}

	@BeforeClass
	@Parameters({ "Browser" })
	public void beforeTest() {
		driver = objConfig.mthdBeforeTest(this.getClass().getSimpleName(), "Browser");
		System.out.println("Before Method executed ");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite...");
		objConfig.mthdBeforeSuite();

	}

	@AfterClass
	public void afterTest() {
		objConfig.mthdAfterTest();
	}

	@AfterSuite
	public void afterSuite() {
		objConfig.mthdAfterSuite();

	}
}
