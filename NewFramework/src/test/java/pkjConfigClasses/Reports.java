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

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	public ExtentHtmlReporter myHtmlReporter;
	public ExtentReports myReport;
	public ExtentTest myTest;
	public String varTestcaseName;

	public void mthdCreateHtmlReport(String htmlreportPath) {

		try {

			myHtmlReporter = new ExtentHtmlReporter(htmlreportPath);
			myReport = new ExtentReports();
			myReport.attachReporter(myHtmlReporter);
			System.out.println("New Html Report created...");
		}

		catch (Exception e) {

			System.out.println("Error ocurred......." + e.getStackTrace());

		}

	}

	public void mthdCreateNewTestInReport(String varTestCaseName) {
		try {
			this.varTestcaseName = varTestCaseName;
			myTest = myReport.createTest(varTestCaseName);
			System.out.println("New Test is created in Html report");
		}

		catch (Exception e) {
			System.out.println("Error occured in Creating New test in Html report" + e.getStackTrace());
		}

	}

	public void mthdEndReport() {

		myReport.flush();

	}

	public void mthdLog(String msg, String status, String varScreenShotPath) {

		System.out.println("Inside MthLog.....");
		try {
			myTest.log(Status.valueOf(status), msg,
					MediaEntityBuilder.createScreenCaptureFromPath(varScreenShotPath).build());

			System.out.println("Screenshot Attached to test........");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
