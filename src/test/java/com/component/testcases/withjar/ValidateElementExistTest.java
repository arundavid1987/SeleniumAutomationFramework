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
import com.component.pages.ValidateElementExistPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

/**
 * @author Umme.Salma
 *
 */
public class ValidateElementExistTest {

	public WebDriver driver;
	public ValidateElementExistPage objValidateElementExistPage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlDisAppearingElement"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();

		}	 
	 

	@Test(priority = 1)

	public void openTab() throws Exception {

		objValidateElementExistPage = new ValidateElementExistPage(driver).initElements();
		objValidateElementExistPage.elementExist();

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
