package com.component.testcases.withjar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.SliderPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

 

public class SliderTest {

	public WebDriver driver;
	public SliderPage objSliderPage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\ExampleTestData.xlsx";

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();

	}

	@Test()
	public void searchProduct() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		objSliderPage = new SliderPage(driver).initElements();
		etest.log(Status.PASS, "Slider page is loaded");
		objSliderPage.slideElement(30);
		etest.log(Status.PASS, "Data Provider execution is successful");

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
