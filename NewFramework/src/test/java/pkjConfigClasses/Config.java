/*
-----------------------------------------------------------------------------------------------------
|	Developer	: 	Vijay Hire												 					 	 	
*	Project		: 	NewFramework																 
|	Location	: 	Pune																		 
*	Date		: 	2020-06-08											 
|	File		:	caller.java																 
*	Copyright (C) Abibue Tech - All Rights Reserved												 
|   		Unauthorized copying of this file, via any medium is strictly prohibited			 
*   		Proprietary and confidential														 
|  			Written by Vijay Hire <iamvijayhire@gmail.com>.
-----------------------------------------------------------------------------------------------------										 
*/

package pkjConfigClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkjUtilityClasses.Winzip;

public class Config {

	public File parentFolder;
	public String varTimeStamp;
	public String varPathOfParentFolder;
	private static ThreadLocal<String> varPathOfSubFolder = new ThreadLocal<>();
	public File subFolder;
	private static Reports reportObj = new Reports();
	public String varTestCaseName;
	public WebDriver driver;
	// protected static ThreadLocal<WebDriver> driver = new
	// ThreadLocal<WebDriver>();
	public EventFiringWebDriver driver1;
	public String varBrowser;
	public ObjectRepository objRepoitory = new ObjectRepository();

	public Config() {

		System.out.println("I am config Constructor..");
	}

	public synchronized String getPath() {

		return varPathOfSubFolder.get();
	}

	public void mthdCreateParentFolder() {

		try {
			varTimeStamp = new SimpleDateFormat("dd-MMM-yyyy hh.mm a").format(Calendar.getInstance().getTime());

			parentFolder = new File("C:\\Users\\vijay\\git\\newFramework\\NewFramework\\test-output\\" + varTimeStamp);

			if (!parentFolder.exists()) {

				parentFolder.mkdir();
				System.out.println("Parent Folder Created..." + parentFolder);
			}

			varPathOfParentFolder = parentFolder.getAbsolutePath();
		}

		catch (Exception e) {

			System.out.println(e.getStackTrace());
		}

	}

	public void mthdCreateSubFolder(String varTestCaseName) {

		try {
			subFolder = new File(varPathOfParentFolder + "//" + varTestCaseName);
			if (!subFolder.exists()) {

				subFolder.mkdir();
				System.out.println("Sub Folder Created...." + subFolder);

			}

			varPathOfSubFolder.set(subFolder.getAbsolutePath());

		} catch (Exception e) {

			System.out.println(e.getStackTrace());
		}
	}

	public void mthdBeforeSuite() {
		System.out.println("Calling Create Parent Folder");

		mthdCreateParentFolder();
		System.out.println("Calling Create Html Report");

		reportObj.mthdCreateHtmlReport(varPathOfParentFolder + "\\" + varTimeStamp + ".html");

	}

	public synchronized WebDriver mthdBeforeTest(String varTestCaseName, String varBrowser) {

		this.varTestCaseName = varTestCaseName;
		System.out.println("Calling Create Sub Foler()");
		mthdCreateSubFolder(this.varTestCaseName);
		System.out.println("Calling Create New Test Report");
		reportObj.mthdCreateNewTestInReport(this.varTestCaseName);
		this.varBrowser = varBrowser;
		mthdInitWebDriver();
		System.out.println("Switch  case executed...");
		System.out.println("Returning Driver...");
		return driver;
	}

	public void mthdAfterTest(WebDriver driver1) {
		driver1.close();
	}

	public void mthdAfterSuite() {
		try {
			driver.quit();

			reportObj.mthdEndReport();
			// Winzip.pack(this.varPathOfParentFolder, "G:\\ReportBackup\\compress.zip");
		} catch (Exception e) {
			System.out.println("Error Occured in Zip" + e);
		}
	}

	public synchronized void mthdInitWebDriver() {
		switch (this.varBrowser) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver = Config.getDriver();
			System.out.println("Inside Switch Case");

			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "G:\\IEDriverServer.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			break;
		default:
			System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

			break;
		}
		System.out.println("Calling Register Method...");
		driver = EventListener.mthdRegisterWebDriver(driver);
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void log(String msg, String status, String str) {

		reportObj.mthdLog(msg, status, str);
	}

}
