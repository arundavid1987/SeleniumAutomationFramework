package com.component.testcases.withjar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ShadowDomTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 	  
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlShadowDom"})
		public void setupBrowser(String browser, String url) throws Exception {		 
			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			  
		}
	 
	 	 @Test(priority=1,enabled=true)
	 	public void HandlingWithoutShadowDom() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Get the data  ");
	 		String value=driver.findElement(By.xpath("//*[@id=\"content\"]/my-paragraph[1]/span")).getText();
	 		etest.log(Status.PASS, "value :"+value);
	 		System.out.println("value :"+value);
	 	}
	 	
	 	@Test(priority=2,enabled=true)
	 	public void HandlingShadowDom() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Get the data  ");
	 		  JavascriptExecutor jse = (JavascriptExecutor) driver; 
	 		  WebElement text= (WebElement) jse.executeScript("return document.querySelector('#content > my-paragraph:nth-child(4)').shadowRoot.querySelector('p> slot')");
			  
			  String value= text.getText();
			 
	 		System.out.println("value :"+value);
	 	}
	 	 
	  
	 	
	 	   @AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

}

