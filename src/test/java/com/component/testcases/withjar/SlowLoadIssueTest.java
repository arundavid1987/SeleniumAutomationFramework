package com.component.testcases.withjar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.SlowLoadIssuePage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class SlowLoadIssueTest {

	public WebDriver driver;
	public SlowLoadIssuePage objSlowLoad;
	ExtentListeners objExtentListeners = new ExtentListeners();

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "urlSlow" })
	public void setupBrowser(String browser, String url) throws Exception {
		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();

	}

	/**
	 * Test case is created to handle application slow load issus
	 * 
	 * @author Senthil.Arumugam
	 * @param number of time need to check , report object
	 * @throws Exception
	 */

	@Test(priority = 1, enabled = true)
	public void fnSlowLoadIssue() throws Exception {
		 
		ExtentTest etest = objExtentListeners.getTest().get();
		objSlowLoad = new SlowLoadIssuePage(driver).initElements();
		etest.log(Status.PASS, "Slow Resources page is loaded");

		objSlowLoad.fnSlowLoadIssue(5, etest);

		etest.log(Status.PASS, "slow load issues funtion is waited untill to load particular object in UI");
		System.out.println("Last Check");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
