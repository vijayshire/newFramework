package pkjTestCasesClasses;

import org.testng.annotations.Test;

import pkjConfigClasses.Config;

import org.testng.annotations.AfterSuite;

public class InitAfterSuite {
	Config con = new Config();

	@Test
	public void f() {

		System.out.println("Closing All Instances..All");
	}

	@AfterSuite
	public void afterSuite() {

		con.mthdAfterSuite();

	}

}
