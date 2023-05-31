/**
 * 
 */
package com.component.testcases.withjar;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.component.pages.AlertPage;
import com.component.pages.CalenderPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;


/**
 * @author Hajeera.bilal
 *
 */
public class AlertpopUpTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 ReusableComponents reusableComponents;
	 AlertPage objAlertPage;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlAlert"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  reusableComponents=new ReusableComponents(driver);
		}
	 
	 
	@Test
	public void webDriverSetUp() throws InterruptedException {
		objAlertPage  = new AlertPage(driver).initElements();
 
		objAlertPage.handleAlert();

		// handling Modal Popup
		objAlertPage.handleModalPopup();
		 

		// handling Ajax Loader
		objAlertPage.ajxxLoader();

	}
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }


}
