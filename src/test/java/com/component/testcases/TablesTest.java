package com.component.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.TablesPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class TablesTest {
	public WebDriver driver;
	public TablesPage objTablesPage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\TablesTestData.xlsx";
	public HashMap<String, String> tablesData;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url2" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();

	}

	@Test(priority = 1, enabled = true)
	public void tableOperations() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		objTablesPage = new TablesPage(driver).initElements();
		etest.log(Status.PASS, "Tables Page is loaded");

		tablesData = new ExcelReader().getCommonData(excelPath, "TestData", "ColumnName1");
		boolean sumRecon = objTablesPage.checkSumColumn(tablesData.get("ColumnName1"));
		if (sumRecon)
			etest.log(Status.PASS, "Price sum is verified successfully");
		else
			etest.log(Status.FAIL, "Price sum is not verified correctly");
		etest.log(Status.INFO, "Test Data : "+tablesData.get("ColumnName1"));
		

		tablesData = new ExcelReader().getCommonData(excelPath, "TestData", "RelativeData");
		int rowNo = objTablesPage.relativeCellClick(tablesData.get("RelativeData"));
		if (rowNo > 0)
			etest.log(Status.PASS, "Relative data is checked successfully");
		else
			etest.log(Status.FAIL, "Realtive data could not be found");
		etest.log(Status.INFO, "Test Data : "+tablesData.get("RelativeData"));

		tablesData = new ExcelReader().getCommonData(excelPath, "TestData", "ColumnName2");
		boolean tableSorted = objTablesPage.checkSorting(tablesData.get("ColumnName2"));
		if (tableSorted)
			etest.log(Status.PASS, "Table is sorted properly");
		else
			etest.log(Status.FAIL, "Table is not sorted");
		etest.log(Status.INFO, "Test Data : "+tablesData.get("ColumnName2"));
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
