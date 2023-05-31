package com.example.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import co.in.amazon.pages.AmazonPage;

public class AmazonCommonDataTest {
	
	 public WebDriver driver;
	 public AmazonPage objAmazonPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\ExampleTestData.xlsx";
	 public HashMap<String, String> commonData ;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "url"})
	public void setupBrowser(String browser, String url) throws Exception {
		 commonData=  new ExcelReader().getCommonData(excelPath,"CommonData","commonsearch","commonsearch_asserttext");		  
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
		
	}
 
	 
	 /**
	  * Test case with CommonData search value
	  *  
	  * @throws Exception
	  */
	
	 @Test(priority=2,enabled=true)
	public void searchProductCommondata() throws Exception{
		 ExtentTest etest=objExtentListeners.getTest().get();
		 objAmazonPage=new AmazonPage(driver).initElements();
		 etest.log(Status.PASS, "Amazon India page is loaded");
		 objAmazonPage.searchProduct(commonData.get("commonsearch"),commonData.get("commonsearch_asserttext"));
		 etest.log(Status.PASS, "Search Product 'Sanitizer' execution is successful ");
		 		
	}
	 
	 
	
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
