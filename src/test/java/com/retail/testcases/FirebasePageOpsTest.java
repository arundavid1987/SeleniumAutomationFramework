package com.retail.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.retail.pages.FirebasePage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class FirebasePageOpsTest {

	public WebDriver driver;
	public FirebasePage objFirebasePage;
	ExtentListeners objExtentListeners = new ExtentListeners();
	public String excelPath = System.getProperty("user.dir") + "\\TestData\\FirebaseTestData.xlsx";
	public HashMap<String, String> dropdownData;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void setupBrowser(String browser, String url) throws Exception {

		SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
		this.driver = setupTestDriver.getDriver();

	}

	@Test(priority = 1, enabled = true)
	public void firebasePageOps() throws Exception {
		ExtentTest etest = objExtentListeners.getTest().get();
		objFirebasePage = new FirebasePage(driver).initElements();
		etest.log(Status.PASS, "Firebase app is loaded");

		dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "Size");
		objFirebasePage.selectSize(dropdownData.get("Size"));
		etest.log(Status.PASS, "Selected item size");

		dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "ProductName");
		boolean productAdded = objFirebasePage.addToCart(dropdownData.get("ProductName"));
		if (productAdded)
			etest.log(Status.PASS, "Product added to cart successfully!!");
		else
			etest.log(Status.FAIL, "Product can not be added to cart..");

		dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "AlertText");
		boolean checkoutDone = objFirebasePage.checkout(dropdownData.get("AlertText"));
		if (checkoutDone)
			etest.log(Status.PASS, "Checkout done successfully!!");
		else
			etest.log(Status.FAIL, "Checkout can not be done..");

		dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "ProductName");
		boolean productRemoved = objFirebasePage.removeFromCart(dropdownData.get("ProductName"));
		if (productRemoved)
			etest.log(Status.PASS, "Product removed from cart successfully!!");
		else
			etest.log(Status.FAIL, "Product can not be removed from cart..");

		dropdownData = new ExcelReader().getCommonData(excelPath, "TestData", "AlertText");
		checkoutDone = objFirebasePage.checkout(dropdownData.get("AlertText"));
		if (checkoutDone)
			etest.log(Status.PASS, "Checkout done successfully!!");
		else
			etest.log(Status.FAIL, "Checkout can not be done..");

		objFirebasePage.closeCart();
		etest.log(Status.PASS, "Closed the cart");

	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
