/*
-----------------------------------------------------------------------------------------------------
|	Developer	: 	Vijay Hire												 					 	 	
*	Project		: 	NewFramework																 
|	Location	: 	Pune																		 
*	Date		: 	2020-06-10											 
|	File		:	LoginPage.java																 
*	Copyright (C) Abibue Tech - All Rights Reserved												 
|   		Unauthorized copying of this file, via any medium is strictly prohibited			 
*   		Proprietary and confidential														 
|  			Written by Vijay Hire <iamvijayhire@gmail.com>.
-----------------------------------------------------------------------------------------------------										 
*/
package pkjFunctionsClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkjConfigClasses.Config;
import pkjConfigClasses.ObjectRepository;
import pkjConfigClasses.Reports;
import pkjUtilityClasses.Screenshots;
import pkjConfigClasses.EventListener;

public class LoginPage {

	// Reports obj = new Reports();
	public ObjectRepository objRepoitory = new ObjectRepository();
	public Config objConfig1 = new Config();
	public Screenshots objScrShot = new Screenshots();

	public LoginPage() {
		System.out.println("I am LoginPage constructor...");

	}

	public boolean txtBoxUserName(WebDriver driver, String userName) throws IOException {

		try {
			objRepoitory.mthdCreateObjectRepository();

			System.out
					.println("Inside Login Page username method..." + objRepoitory.objRepo.getProperty("loginDialog"));

			if (driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginDialog"))).isEnabled()) {
				System.out.println("inside if Login Link......");

				driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginDialogClose"))).click();
			}
			Thread.sleep(10000);
			System.out.println("Checking Login Link......");
			driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginLink"))).click();
			System.out.println("Clicked..........");
			driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginUserName"))).sendKeys(userName);

			return true;

		}

		catch (Exception e) {
			System.out.println("Getting error in Username catch");
			String str = objScrShot.mthdTakeScreenShot(driver,
					objConfig1.getPath() + "\\Step-" + EventListener.getCount() + ".png");
			System.out.println("Path.." + str);
			objConfig1.log("Failed to enter username", "FAIL", str);
			System.out.println("Error Occurred" + e.getStackTrace());

			return false;
		}
	}

	public boolean txtBoxPassword(WebDriver driver, String password) throws IOException {

		try {

			driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginPassowrd"))).sendKeys(password);
			return true;
		}

		catch (Exception e) {

			String str = objScrShot.mthdTakeScreenShot(driver,
					objConfig1.getPath() + "\\ Step:" + EventListener.getCount() + ".png");
			objConfig1.log("Failed to enter username", "FAIL", str);
			System.out.println("Error Occurred" + e);
			return false;
		}

	}

	public boolean btnLogin(WebDriver driver) throws IOException {

		try {

			driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("loginBtn"))).click();
			Thread.sleep(5000);

			return true;
		}

		catch (Exception e) {
			String str = objScrShot.mthdTakeScreenShot(driver,
					objConfig1.getPath() + "\\ Step:" + EventListener.getCount() + ".png");
			objConfig1.log("Failed to enter username", "FAIL", str);
			System.out.println("Error Occurred" + e);
			return false;

		}

	}

	public boolean chknLogin(WebDriver driver) throws IOException {
		try {

			String txt = driver.findElement(By.xpath(objRepoitory.objRepo.getProperty("chkLogin"))).getText();

			String error1 = "Please enter valid Email ID/Mobile number";
			String error2 = "Your username or password is incorrect";
			if (txt.equalsIgnoreCase(error1) || txt.equalsIgnoreCase(error2))
				return false;
			else
				return true;

		}

		catch (Exception e) {
			String str = objScrShot.mthdTakeScreenShot(driver,
					objConfig1.getPath() + "\\ Step:" + EventListener.getCount() + ".png");
			objConfig1.log("Failed to enter username", "FAIL", str);
			System.out.println("Error Occurred" + e);
			return false;

		}

	}

}
