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

public class BasicAuthTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 	  
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlAlert"})
		public void setupBrowser(String browser, String url) throws Exception {
		 url="https://admin:admin@the-internet.herokuapp.com/basic_auth";
			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  
		}
	 
	 	@Test(priority=1,enabled=true)
	 	public void HandlingBaiscAuth() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Basic Authentication using browser values. Logged in Successfully.");
	 		 
	 	}
	  
	 	
	 	  @AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

}

