/*
-----------------------------------------------------------------------------------------------------
|	Developer	: 	Vijay Hire												 					 	 	
*	Project		: 	NewFramework																 
|	Location	: 	Pune																		 
*	Date		: 	2020-06-10											 
|	File		:	EventListener.java																 
*	Copyright (C) Abibue Tech - All Rights Reserved												 
|   		Unauthorized copying of this file, via any medium is strictly prohibited			 
*   		Proprietary and confidential														 
|  			Written by Vijay Hire <iamvijayhire@gmail.com>.
-----------------------------------------------------------------------------------------------------										 
*/
package pkjConfigClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import pkjUtilityClasses.Screenshots;

public class EventListener extends AbstractWebDriverEventListener {

	// public WebDriver driver;
	public static EventFiringWebDriver driver1;
	public static EventListener refEventListener;
	Screenshots objScrShot = new Screenshots();
	public Config objConfig = new Config();

	private static ThreadLocal<Integer> i = new ThreadLocal<>();

	public static int getCount() {
		i.set(i.get() + 1);

		return i.get();

	}

	public synchronized static WebDriver mthdRegisterWebDriver(WebDriver driver) {
		System.out.println("I am Event Listener, Regitering driver now...");
		driver1 = new EventFiringWebDriver(driver);
		refEventListener = new EventListener();
		driver1.register(refEventListener);
		System.out.println("Registered Successfully...");
		i.set(0);
		return driver1;
	}

	@Override
	public synchronized void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on Element" + element);
		String str = objScrShot.mthdTakeScreenShot(driver1,
				objConfig.getPath() + "\\Step-" + EventListener.getCount() + ".png");
		System.out.println("Str" + str);
		objConfig.log("Clicked on Successfully", "PASS", str);
	}

	@Override
	public synchronized void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to " + url + " successfully");
		String str = objScrShot.mthdTakeScreenShot(driver1,
				objConfig.getPath() + "\\Step-" + EventListener.getCount() + ".png");
		System.out.println("Str" + str);
		objConfig.log("Navigated To " + url + " Successfully", "PASS", str);

	}

	@Override
	public synchronized void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to Click on Element");
	}

	@Override
	public synchronized void beforeNavigateTo(String url, WebDriver driver) {

		System.out.println("Tryng to Navigate to URL" + url);
	}

	@Override
	public synchronized void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

		System.out.println("Value" + keysToSend + " has been entered..");
		String str = objScrShot.mthdTakeScreenShot(driver1,
				objConfig.getPath() + "\\Step-" + EventListener.getCount() + ".png");
		System.out.println("Str" + str);
		objConfig.log("Value" + keysToSend + " has been entered..", "PASS", str);
	}

	@Override
	public synchronized void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Trying to enter value.......");
	}

}
