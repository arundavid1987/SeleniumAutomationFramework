package com.component.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.FileUploadPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class FileUploadTest {
	 public WebDriver driver;
	 public FileUploadPage objFileUploadPage;
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 public String excelPath=System.getProperty("user.dir")+"\\TestData\\FileUpload.xlsx";
	 public HashMap<String, String> fileUploadData;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "url7"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
		}
	 
	 	@Test(priority=1,enabled=true)
	 	public void FileUploadPage() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();
	 		objFileUploadPage = new FileUploadPage(driver).initElements();
	 		etest.log(Status.PASS, "FileUpload Page is loaded");
			
	 		fileUploadData = new ExcelReader().getCommonData(excelPath, "TestData", "FileName");
	 		System.out.println(fileUploadData.get("FileName"));
	 		objFileUploadPage.uploadFile(fileUploadData.get("FileName"));
	 		etest.log(Status.PASS, "FileUploaded Successfully");
	 	}
}