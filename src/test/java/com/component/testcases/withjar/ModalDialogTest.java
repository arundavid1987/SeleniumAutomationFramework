package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.ModalDialogPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;



public class ModalDialogTest {
	
	 public WebDriver driver;
	 public ModalDialogPage objModal;
	 
	 ExtentListeners objExtentListeners= new ExtentListeners();
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\ModalDialogTestData.xlsx";
	 public HashMap<String, String> commonData ;
	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlModalDialogs"})
	 public void setupBrowser(String browser, String url) throws Exception {
		 commonData=  new ExcelReader().getCommonData(excelPath,"CommonData","Small_Modal","Large_Modal");		  
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();
	         
	 }
 
	 /**
	  * Test case for Handling Modal Dialog
	  * No Excel reader
	  * @throws Exception
	  */
	
	 @Test(priority=1,enabled=true)
	public void handleModalDialog() throws Exception{
		 ExtentTest etest=objExtentListeners.getTest().get();
		 objModal=new ModalDialogPage(driver).initElements();
		 etest.log(Status.PASS, "Tools QA page is loaded");
		 
		 objModal.GetSmallModalDialogText(commonData.get("Small_Modal"));
		 etest.log(Status.PASS, "Verified Small Modal Dialog Text Successfully");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("Small_Modal"));
		 
		 objModal.GetLargeModalDialogText(commonData.get("Large_Modal"));
		 etest.log(Status.PASS, "Verified Large Modal Dialog Text Successfully");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("Large_Modal"));
		 		
	}
	 

	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
