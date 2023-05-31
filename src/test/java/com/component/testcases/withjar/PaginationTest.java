/**
 * 
 */
package com.component.testcases.withjar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.component.pages.PaginationPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

/**
 * @author Umme.Salma
 *
 */
public class PaginationTest {

	public WebDriver driver;
	public PaginationPage objPaginationPage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlDatatable"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();

		}	 
	 

	@Test(priority = 1)

	public void openTab() throws Exception {

		objPaginationPage = new PaginationPage(driver).initElements();
		objPaginationPage.paginationSize();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
