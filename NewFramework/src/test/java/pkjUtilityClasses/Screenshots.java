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
package pkjUtilityClasses;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public synchronized String mthdTakeScreenShot(WebDriver driver, String varFileWithpath) {
		try {
			System.out.println("Inside Screenshot...");
			Thread.sleep(5000);
			TakesScreenshot objScreenShot = (TakesScreenshot) driver;
			File screenshot = objScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(varFileWithpath);
			FileUtils.copyFile(screenshot, destFile);

			return destFile.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
			return varFileWithpath;
		}
	}

}
