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

public class HandleIframeTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	
	 ReusableComponents reusableComponents;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urliframe"})
		public void setupBrowser(String browser, String url) throws Exception {
		  
			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
			
		}
	 
	 	@Test(priority=1,enabled=true)
	 	public void HandlingiFrame() throws Exception {
	 		reusableComponents=new ReusableComponents(driver);			  
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Handling Iframe");
	 		 driver.findElement(By.partialLinkText("Nested")).click();
	 	      // switching to frame with frame name
	 		reusableComponents.switchToFrame("frame-bottom");	 	      
	 	      WebElement m = driver.findElement(By.cssSelector("body"));
	 	      System.out.println("Frame text: " +m.getText()); 
	 	     etest.log(Status.PASS, "Frame text: " +m.getText());
	 	}
	  
	 	
	 	  @AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

}

