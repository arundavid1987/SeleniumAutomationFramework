package com.component.testcases.withjar;

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

import hm.selenium.ReusableComponents;

public class CanvasTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlCanvasTest"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  
		}
	public CanvasPage objCanvasPage;
	 
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\CanvasTestData.xlsx";
	public HashMap<String, String> tablesData;

 

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
