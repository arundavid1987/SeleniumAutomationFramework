package com.example.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import co.in.amazon.pages.AmazonPage;

public class AmazonSimpleTest {
	
	 public WebDriver driver;
	 public AmazonPage objAmazonPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();
	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "url"})
	public void setupBrowser(String browser, String url) throws Exception {
		 
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
		
	}
 
	 /**
	  * Test case with Direct value search
	  * No Excel reader
	  * @throws Exception
	  */
	
	 @Test(priority=1,enabled=true)
	public void searchProductDirectSearch() throws Exception{
		 ExtentTest etest=objExtentListeners.getTest().get();
		 objAmazonPage=new AmazonPage(driver).initElements();
		 etest.log(Status.PASS, "Amazon India page is loaded");
		 objAmazonPage.searchProduct("Mi Smart Band 5","Mi Smart Band 5");
		 etest.log(Status.PASS, "Search Product 'Sanitizer' execution is successful ");
		 		
	}
	 

	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
