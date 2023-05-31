/**
 * 
 */
package com.component.testcases.withjar;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.component.pages.CalenderPage;
import com.component.pages.CanvasPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;



/**
 * @author Hajeera.bilal
 *
 */
public class CalendarTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 CalenderPage objCalenderPageObject;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlCalendar"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  
		}
	
	
	@Test
	public void webDriverSetUp() throws Exception {
		objCalenderPageObject = new CalenderPage(driver).initElements();
		objCalenderPageObject.handleCalendar();

		 
	}
	
	  @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
