package com.component.testcases.withjar;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.component.pages.MultipleTabPage;
import com.component.pages.ProgressBarPage;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import java.util.HashMap;

public class ProgressbarTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public ProgressBarPage objProgress;
    ExtentListeners objExtentListeners = new ExtentListeners();
    
	 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlProgressBar"})
	 public void setupBrowser(String browser, String url) throws Exception {
		   
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();
	        
	 }
   

    @Test(enabled = true)
    public void progressbar() throws Exception {
        objProgress = new ProgressBarPage(driver).initElements();
        objProgress.WaitForValueInAttribute("value", "100");
        objProgress.WaitForText("Stopped");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
