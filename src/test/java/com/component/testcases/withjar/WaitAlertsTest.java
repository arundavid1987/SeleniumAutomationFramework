/**
 * 
 */
package com.component.testcases.withjar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.JavaScriptPage;
import com.component.pages.WaitPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

/**
 * @author Manas.parhi
 *
 */
public class WaitAlertsTest {

	public WebDriver driver;
	ExtentListeners objExtentListeners = new ExtentListeners();
	WaitPage objWaitPage;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlWaitAlert"})
	public void setupBrowser(String browser, String url) throws Exception {
	 
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
	         
	}
	 
	 
	@Test
	public void waitHandling() throws InterruptedException {
		objWaitPage  = new WaitPage(driver).initElements();
		PageFactory.initElements(driver, WaitPage.class);

		ExtentTest etest = objExtentListeners.getTest().get();

		// handling Wait Alert
		objWaitPage.simpleAlert();

		objWaitPage.handleAlert();
		
		etest.log(Status.PASS, "Wait alerts tested successfully");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() { 
		driver.quit(); 
	}

}
