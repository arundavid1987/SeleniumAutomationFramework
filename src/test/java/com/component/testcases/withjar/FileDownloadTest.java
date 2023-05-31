package com.component.testcases.withjar;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.FileDownloadPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;

public class FileDownloadTest {
	 public WebDriver driver;
	 public FileDownloadPage objFileDownloadPage;
	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\FileDownload.xlsx";
	 public HashMap<String, String> fileDownloadData;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlDownload"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			 
		}
	 
	 	@Test(priority=1,enabled=true)
	 	public void FileDownloadPage() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();
	 		objFileDownloadPage = new FileDownloadPage(driver).initElements();
	 		etest.log(Status.PASS, "FileDownload Page is loaded");
			
	 		fileDownloadData = new ExcelReader().getCommonData(excelPath, "TestData", "FileName");
	 		objFileDownloadPage.downloadFiles(fileDownloadData.get("FileName"));
	 		etest.log(Status.PASS, "File Downloaded Successfully");	
	 	}
	 	
	 	@AfterMethod(alwaysRun = true)
		public void closeBrowser() {
			driver.quit();
		}
}

