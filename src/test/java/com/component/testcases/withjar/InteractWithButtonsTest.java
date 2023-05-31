package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.ButtonPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class InteractWithButtonsTest {
	
	public WebDriver driver;
	public ButtonPage objButtonPage;
	 
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\TablesTestData.xlsx";
	public HashMap<String, String> tablesData;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "urlButtons" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();
		 

	}

	@Test
	public void handleMultipleButtons() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		etest.log(Status.PASS, "Multiple Tab Page is loaded");
		objButtonPage= new ButtonPage(driver).initElements();
		// goToHome
		objButtonPage.goToHomePage();
		etest.log(Status.PASS, "Validated Home Page Button");
		driver.get("https://letcode.in/buttons");

		// buttonLocation
		objButtonPage.getLocation();
		etest.log(Status.PASS, "Validated Location of Element");
		// buttonColor
		
		objButtonPage.getBackgroundColor();
		etest.log(Status.PASS, "Validated background color");
		// getSizeOfButton
		objButtonPage.getSize();
		etest.log(Status.PASS, "Validated Size of element");

		// ButtonENabledorNot?
		objButtonPage.isElementEnabled();
		etest.log(Status.PASS, "Validated Element is enabled or not");
		
		 
	 
}
	

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}