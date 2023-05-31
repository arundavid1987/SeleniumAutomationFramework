package com.component.testcases;




import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.component.pages.AutoCompletePage;
import com.utils.setupdriver.SetupTestDriver;


public class AutoCompleteTextTest {

		 public WebDriver driver;
		 public AutoCompletePage objAutoCompletePage;
		
		
		 @BeforeTest(alwaysRun = true)
		 public void setupBrowser() throws Exception {
			 String browser ="chrome";
			 String url ="https://demoqa.com/auto-complete";
			 
			 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		     this.driver = setupTestDriver.getDriver();	
		}
		 
		
		 @Test (priority =1)
			
		 public void enterText() throws Exception{
			 objAutoCompletePage = new AutoCompletePage(driver).initElements();
			 objAutoCompletePage.enterMultiColor();
			 objAutoCompletePage.enterSingleColor();
		}
		 
		@AfterTest
		public void closeBrowser() {
		 driver.quit();
		}
		
		
	}


