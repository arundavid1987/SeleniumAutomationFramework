package com.component.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.component.pages.MultipleTabPage;
import com.utils.setupdriver.SetupTestDriver;

public class MultipleTabTest
{
	 public WebDriver driver;
	 public MultipleTabPage objMultipleTabPage;
	
	
	 @BeforeTest(alwaysRun = true)
	 public void setupBrowser() throws Exception {
		 String browser ="chrome";
		 String url ="https://demoqa.com/browser-windows";
		 
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
	 
	@AfterTest
	public void closeBrowser() {
	 driver.quit();
	}
	
	

}
