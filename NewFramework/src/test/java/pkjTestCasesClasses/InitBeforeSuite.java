package pkjTestCasesClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class InitBeforeSuite {
	@Test
	public void f() {

		System.out.println("Initiating all instances...");
	}

	@BeforeSuite
	public void beforeSuite() {

	}

}
