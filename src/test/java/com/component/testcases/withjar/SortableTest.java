package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.SortablePage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;

public class SortableTest {

	public WebDriver driver;
	 public SortablePage objSortablePage;
	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\SortableTestData.xlsx";
	 public HashMap<String, String> sortableData;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlSortable"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			 
		}
	 
	 	@Test(priority=1,enabled=true)
		public void sortList() throws Exception {
		 ExtentTest etest = objExtentListeners.getTest().get();
			objSortablePage = new SortablePage(driver).initElements();
			etest.log(Status.PASS, "Sortable Page is loaded");
			
			sortableData = new ExcelReader().getCommonData(excelPath, "TestData", "OrderList");	
			objSortablePage.sortList(sortableData.get("OrderList"));
			etest.log(Status.PASS, "List is now sorted as given");
			
			sortableData = new ExcelReader().getCommonData(excelPath, "TestData", "OrderGrid");			
			objSortablePage.sortGrid(sortableData.get("OrderGrid"));
			etest.log(Status.PASS, "Grid is now sorted as given");
			
			sortableData = new ExcelReader().getCommonData(excelPath, "TestData", "OrderThird");			
			objSortablePage.sortThird(sortableData.get("OrderThird"));
			etest.log(Status.PASS, "Grid is now sorted as given");
	 }
	 	
	 	
	 	@AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	         driver.quit();
	    }
}
