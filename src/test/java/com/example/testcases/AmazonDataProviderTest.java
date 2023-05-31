package com.example.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import co.in.amazon.pages.AmazonPage;

public class AmazonDataProviderTest {
	
	 public WebDriver driver;
	 public AmazonPage objAmazonPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\ExampleTestData.xlsx";
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "url"})
	public void setupBrowser(String browser, String url) throws Exception {
		 
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
		
	}
 
	 
	 
	 @DataProvider(name = "multiplesearch") 
		public Object[][] searchTestData() throws Exception {
			Object[][] result = new ExcelReader().getDataProviderData(excelPath,"multisearch"); 
			return result; 
		} 
 
		@Test(dataProvider = "multiplesearch",priority=3,enabled=true)
		public void searchProduct(String searchtext,String asserttext) throws Exception{
		 ExtentTest etest=objExtentListeners.getTest().get();
		 objAmazonPage=new AmazonPage(driver).initElements();
			 etest.log(Status.PASS, "Amazon India page is loaded");
			 objAmazonPage.searchProduct(searchtext,asserttext);
			 etest.log(Status.PASS, "Data Provider execution is successful");
			 		
		}
	 	 
 
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
