package com.component.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.CanvasPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class CanvasTest {
	public WebDriver driver;
	public CanvasPage objCanvasPage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\CanvasTestData.xlsx";
	public HashMap<String, String> tablesData;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url3" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();

	}

	@Test(priority = 1, enabled = true)
	public void CanvasOperations() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		objCanvasPage = new CanvasPage(driver).initElements();
		etest.log(Status.PASS, "Canvas page is loaded");

		tablesData = new ExcelReader().getCommonData(excelPath, "TestData", "Instruction");
		objCanvasPage.drawShape(tablesData.get("Instruction"));
		etest.log(Status.PASS, "Canvas shape drawn successfully");
		
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}


}
