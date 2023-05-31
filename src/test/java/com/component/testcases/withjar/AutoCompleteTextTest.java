package com.component.testcases.withjar;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.component.pages.AutoCompletePage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;


public class AutoCompleteTextTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 ReusableComponents reusableComponents;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlAutoComplete"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  reusableComponents=new ReusableComponents(driver);
		}
		 
		 public AutoCompletePage objAutoCompletePage;
 
		 @Test (priority =1)
			
		 public void enterText() throws Exception{
			 objAutoCompletePage = new AutoCompletePage(driver).initElements();
			 objAutoCompletePage.enterMultiColor();
			 objAutoCompletePage.enterSingleColor();
		}
		 
		 
		 @AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

		
		
	}


