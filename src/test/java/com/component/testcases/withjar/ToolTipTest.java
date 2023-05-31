package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.ToolTipPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;


public class ToolTipTest {
	
	 public WebDriver driver;
	 public ToolTipPage objHover;
	 ExtentListeners objExtentListeners= new ExtentListeners();
	
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\ToolTipTestData.xlsx";
	 public HashMap<String, String> commonData ;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlTooltip"})
	public void setupBrowser(String browser, String url) throws Exception {
		 commonData=  new ExcelReader().getCommonData(excelPath,"CommonData","ToolTip_Button","ToolTip_TextField","ToolTip_AlphabeticLink","ToolTip_NumericLink");		  
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
	         
	}
 
	 
	 /**
	  * Test case with CommonData search value
	  *  
	  * @throws Exception
	  */
	
	 @Test(priority=2,enabled=true)
	public void hoveringElement() throws Exception{
		 ExtentTest etest=objExtentListeners.getTest().get();
		 objHover=new ToolTipPage(driver).initElements();
		 etest.log(Status.PASS, "Tools QA page is loaded");
		 Thread.sleep(6000);
			
		 objHover.HoverButton(commonData.get("ToolTip_Button"));
		 etest.log(Status.PASS, "Hovering the button is executed successfully ");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("ToolTip_Button"));
		 
		 objHover.HoverTextField(commonData.get("ToolTip_TextField"));
		 etest.log(Status.PASS, "Hovering the TextField is executed successfully ");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("ToolTip_TextField"));
		 
		 objHover.HoverAlphabeticLink(commonData.get("ToolTip_AlphabeticLink"));
		 etest.log(Status.PASS, "Hovering the Alphabetic Link is executed successfully");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("ToolTip_AlphabeticLink"));
		 
		 objHover.HoverNumericLink(commonData.get("ToolTip_NumericLink"));
		 etest.log(Status.PASS, "Hovering the Numeric Link is executed successfully");
		 etest.log(Status.INFO, "Test Data : "+commonData.get("ToolTip_NumericLink"));
		 		
	}
	 
	 
	
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
