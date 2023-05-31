package com.component.testcases.withjar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import com.component.pages.DynamicElementsPage;

public class DynamicElementsTest {

	 public WebDriver driver;
	 public DynamicElementsPage objDynamicElementsPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlDynamicProperties"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();

		}	 
 
		@Test(priority=1,enabled=true)
		public void dynamicElementsOperations() throws Exception {
			ExtentTest etest = objExtentListeners.getTest().get();
			objDynamicElementsPage = new DynamicElementsPage(driver).initElements();
			etest.log(Status.PASS, "Dynamic Elements Page Objects Initialized");
			
			String[] propValues=objDynamicElementsPage.verifyElementEnabled();
			etest.log(Status.INFO, "Element is enabled: "+propValues[0]);
			etest.log(Status.INFO, "Element is enabled after 5 seconds: "+propValues[1]);
			etest.log(Status.PASS, "Verified element is enabled or not");
			
			propValues=objDynamicElementsPage.verifyElementPropertyChange();
			etest.log(Status.INFO, "Property value before color change: "+propValues[0]);
			etest.log(Status.INFO, "Property value after color change: "+propValues[1]);
			etest.log(Status.PASS, "Verified class property value before and after color change");
			
			propValues=objDynamicElementsPage.verifyElementDisplayed();
			etest.log(Status.INFO, "Element is displayed: "+propValues[0]);
			etest.log(Status.INFO, "Element is displayed after 5 seconds: "+propValues[1]);
			etest.log(Status.PASS, "Verified element is displayed or not ");
			
		}	 	 
 
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
