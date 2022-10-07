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

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	public ExtentReporter myHtmlReporter;
	public ExtentReports myReport;
	public static ThreadLocal<ExtentTest> myTest = new ThreadLocal<ExtentTest>();
	public ExtentTest myTest1;
	public String varTestcaseName;

	public void mthdCreateHtmlReport(String htmlreportPath) {

		try {

			myHtmlReporter = new ExtentHtmlReporter(htmlreportPath);
			myReport = new ExtentReports();
			myReport.attachReporter(myHtmlReporter);
			System.out.println("New Html Report created...");
			myTest.set(myTest1);
		}

		catch (Exception e) {

			System.out.println("Error ocurred......." + e.getStackTrace());

		}

	}

	public synchronized void mthdCreateNewTestInReport(String varTestCaseName) {
		try {
			this.varTestcaseName = varTestCaseName;
			myTest.set(myReport.createTest(varTestCaseName));
			System.out.println("New Test is created in Html report");
		}

		catch (Exception e) {
			System.out.println("Error occured in Creating New test in Html report" + e.getStackTrace());
		}

	}

	public void mthdEndReport() {

		myReport.flush();

	}

	public synchronized void mthdLog(String msg, String status, String varScreenShotPath) {

		System.out.println("Inside MthLog.....");
		try {
			myTest.get().log(Status.valueOf(status), msg,
					MediaEntityBuilder.createScreenCaptureFromPath(varScreenShotPath).build());

			System.out.println("Screenshot Attached to test........");
		} catch (IOException e) {

			System.out.println("Error Occured in Method Log" + e.getStackTrace());
		}

	}

	Reports() {
		int i = 0;
		System.out.println("I am Object" + i++);
	}
}
