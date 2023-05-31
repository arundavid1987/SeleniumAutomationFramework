package com.component.testcases.withjar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

import hm.selenium.ReusableComponents;

public class MenuHandlingTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
	 ReusableComponents reusableComponents;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlMenu"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			
		}
	 
 
	 	 @Test(priority=1,enabled=true)
	 	public void hoverOnTextAndClickFunctionalityTest() throws Exception {
	 		  reusableComponents=new ReusableComponents(driver);
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Mounse hover and  click functionality");
	 		 Thread.sleep(3000);
 
	 		WebElement hoverText = driver.findElement(By.xpath("//*[@id='nav']/li[2]/a")) ;
	 		reusableComponents.hover(hoverText);
	 		 
	 		 Thread.sleep(1000);
	 		WebElement hoverlink = driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li[3]/a"));
	 		reusableComponents.hover(hoverlink);
	 		 Thread.sleep(1000);
	 		WebElement hoverlink2 = driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li[3]/ul/li[2]/a"));
	 		reusableComponents.hover(hoverlink2);
	 		hoverlink2.click();
	 	     etest.log(Status.PASS, "Multiple Menu Items selected");
	 	     System.out.println(  "Multiple Menu Items selected");
	 	}
	 	
	  
	 	  //@AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

}

