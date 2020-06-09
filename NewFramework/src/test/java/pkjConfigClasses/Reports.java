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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {

	public ExtentHtmlReporter myHtmlReporter;
	public ExtentReports myReport;
	public ExtentTest myTest;

	public void mthdCreateHtmlReport(String htmlreportPath) {

		myHtmlReporter = new ExtentHtmlReporter(htmlreportPath);
		myReport = new ExtentReports();
		myReport.attachReporter(myHtmlReporter);

	}

	public void mthdCreateNewTestInReport(String varTestCaseName) {

		myTest = myReport.createTest(varTestCaseName);

	}

	public void mthdEndReport() {

		myReport.flush();

	}

}
