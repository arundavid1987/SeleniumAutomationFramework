package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;

import com.component.pages.DropdownPage;

public class DropdownTest {

	 public WebDriver driver;
	 public DropdownPage objDropdownPage;
	  
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\DropdownTestData.xlsx";
	 public HashMap<String, String> dropdownData;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlDropdown"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			 
		}	 
 
		@Test(priority=1,enabled=true)
		public void dropdownOperations() throws Exception {
			ExtentTest etest = objExtentListeners.getTest().get();
			objDropdownPage = new DropdownPage(driver).initElements();
			etest.log(Status.PASS, "Dropdown Page is loaded");
			
			dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Option1");			
			objDropdownPage.selectValue(dropdownData.get("Option1"));
			etest.log(Status.PASS, "Select Value execution is successful");
			etest.log(Status.INFO, "Test Data : "+dropdownData.get("Option1"));
		
			
			dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Option2");
			objDropdownPage.selectOne(dropdownData.get("Option2"));
			etest.log(Status.PASS, "Select One execution is successful");
			etest.log(Status.INFO, "Test Data : "+dropdownData.get("Option2"));
			
			dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Option3");
			objDropdownPage.selectOldMenu(dropdownData.get("Option3"));
			etest.log(Status.PASS, "Select Old Menu execution is successful");
			etest.log(Status.INFO, "Test Data : "+dropdownData.get("Option3"));
			 
			dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Option4");
			objDropdownPage.multiselectList(dropdownData.get("Option4"));
			etest.log(Status.PASS, "Multiselect List execution is successful");
			etest.log(Status.INFO, "Test Data : "+dropdownData.get("Option4"));
			
			dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Option5");
			objDropdownPage.stdMultiselectList(dropdownData.get("Option5"));
			etest.log(Status.PASS, "Standard Multiselect List execution is successful");
			etest.log(Status.INFO, "Test Data : "+dropdownData.get("Option5"));
		}	 	 
 
	
	 @AfterMethod(alwaysRun = true)
	    public void closeBrowser() {
	        driver.quit();
	    }

}
