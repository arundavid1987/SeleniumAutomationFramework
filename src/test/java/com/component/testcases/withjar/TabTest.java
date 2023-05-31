package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.TabPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

 

public class TabTest {
	public WebDriver driver;
	public TabPage objTabPage;
	 
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\TablesTestData.xlsx";
	public HashMap<String, String> tablesData;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "urlTabs" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();
		 

	}

	@Test
	public void HanldeMultipletabs() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		etest.log(Status.PASS, "Multiple Tab Page is loaded");
		objTabPage= new TabPage(driver).initElements();
		 
		objTabPage.handleTabs();
		etest.log(Status.PASS, "Multiple Tab Validated successfully");
	}
	

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}