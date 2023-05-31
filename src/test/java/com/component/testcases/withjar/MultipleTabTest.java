package com.component.testcases.withjar;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.component.pages.ModalDialogPage;
import com.component.pages.MultipleTabPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;

public class MultipleTabTest
{
	 public WebDriver driver;
	 public MultipleTabPage objMultipleTabPage;
  
	
	 ExtentListeners objExtentListeners= new ExtentListeners();
	  
	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlMultipleTabs"})
	 public void setupBrowser(String browser, String url) throws Exception {
		   
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();
	        
	 }
	
 
	
	 @Test (priority =1)		
	 public void openTab() throws Exception{
		
		 objMultipleTabPage = new MultipleTabPage(driver).initElements();
		 objMultipleTabPage.openNewTab();
		 objMultipleTabPage.getNewTabAndClose();
		 objMultipleTabPage.openNewWindow();
		 objMultipleTabPage.getNewTabAndClose();
		 objMultipleTabPage.openNewWindowMessage();
		 objMultipleTabPage.getNewTabAndClose();
		
		
		
	 }
	 
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }


}
