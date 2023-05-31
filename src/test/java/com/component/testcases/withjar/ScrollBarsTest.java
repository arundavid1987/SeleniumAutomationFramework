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

import com.component.pages.ScrollBarsPage;

public class ScrollBarsTest {

	 public WebDriver driver;
	 public ScrollBarsPage objScrollBarsPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlScrollBar"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();

		}	 
 
		@Test(priority=1,enabled=true)
		public void scrollBarsOperations() throws Exception {
			ExtentTest etest = objExtentListeners.getTest().get();
			objScrollBarsPage = new ScrollBarsPage(driver).initElements();
			etest.log(Status.PASS, "Scroll Bars Page Objects Initialized");
			
			objScrollBarsPage.scrollDown();
			etest.log(Status.PASS, "Scrolled down 5 times");
			
			objScrollBarsPage.scrollUp();
			etest.log(Status.PASS, "Scrolled up 3 times");
						
		}	 	 
 
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
