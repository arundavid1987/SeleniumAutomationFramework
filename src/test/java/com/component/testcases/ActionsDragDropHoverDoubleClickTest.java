package com.component.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

public class ActionsDragDropHoverDoubleClickTest {
	 public WebDriver driver;	 
	 ExtentListeners objExtentListeners= new ExtentListeners();	 
 
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlalert"})
		public void setupBrowser(String browser, String url) throws Exception {

			SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
			this.driver = setupTestDriver.getDriver();
		}
	 
	 	@Test(priority=1,enabled=true)
	 	public void dragAndDropfunctionalityTest() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Validate Drag and Drop functionality");
	 		WebElement fromLoc=driver.findElement(By.xpath("//*[@id='draggable']/p"));
	 		WebElement toLoc=driver.findElement(By.xpath("//*[@id='droppable']/p/b"));	
	 		
	 		 Actions act=new Actions(driver);					
	
	 	         act.dragAndDrop(fromLoc, toLoc).build().perform();	
	 	         
	 	         Thread.sleep(3000);
	  
	 	        String getDroppedText=driver.findElement(By.xpath("//*[@id='droppable']/p/b")).getText();
	 	        Assert.assertEquals(getDroppedText, "Dropped!".trim());
	 	       Thread.sleep(3000);
	 	      etest.log(Status.PASS, "Drag and Drop functionality is working as expected");
	 	     System.out.println(  "Drag and Drop functionality is working as expected");
	 	}
	 	
	 	//@Test(priority=1,enabled=true)
	 	public void doubleClickfunctionalityTest() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Validate double click functionality");
	 		 Thread.sleep(3000);
	 		Actions actions = new Actions(driver);
	 		WebElement elementLocator = driver.findElement(By.xpath("//*[@id='double-click']"));
	 		actions.doubleClick(elementLocator).perform();
	 		 Thread.sleep(3000);
	 		  
	 	        String getClassText=driver.findElement(By.xpath("//*[@id='double-click']")).getAttribute("class");
	 	        Assert.assertEquals(getClassText, "div-double-click double".trim());
	 	       Thread.sleep(3000);
	 	      etest.log(Status.PASS, "double click functionality is working as expected");
	 	     System.out.println(  "double click functionality is working as expected");
	 	}
	 	
	 	
	 	 //@Test(priority=1,enabled=true)
	 	public void hoverOnTextAndClickFunctionalityTest() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Mounse hover and  click functionality");
	 		 Thread.sleep(3000);
	 		Actions actions = new Actions(driver);
	 		WebElement hoverText = driver.findElement(By.xpath("//*[@id='div-hover']/div[3]/button"));
	 		actions.moveToElement(hoverText).perform();
	 		 Thread.sleep(1000);
	 		WebElement hoverlink = driver.findElement(By.xpath("//*[@id='div-hover']/div[3]/div/a[2]"));
	 		actions.click(hoverlink).build().perform();
	 		 Thread.sleep(1000);
	 		 Alert alert=driver.switchTo().alert();
	 		
	 		Assert.assertEquals(alert.getText().trim(), "Well done you clicked on the link!".trim());
	 	       Thread.sleep(3000);
	 	      alert.dismiss();
	 	      etest.log(Status.PASS, "Mounse hover and  click functionality is working as expected");
	 	     System.out.println(  "Mounse hover and  click functionality is working as expected");
	 	}
	 	
	 	
	 	// @Test(priority=1,enabled=true)
	 	public void clickAndHoldFunctionalityTest() throws Exception {
	 		ExtentTest etest = objExtentListeners.getTest().get();	 		 
	 		etest.log(Status.PASS, "Click and hold functionality");
	 		 Thread.sleep(3000);
	 		Actions actions = new Actions(driver);
	 		WebElement clickBox = driver.findElement(By.xpath("//*[@id='click-box']"));
	 		actions.moveToElement(clickBox).clickAndHold(clickBox).perform();

	 		Thread.sleep(5000);

	 		actions.release(clickBox).perform();
	 	      etest.log(Status.PASS, "Click and hold functionality is working as expected");
	 	     System.out.println(  "Click and hold functionality is working as expected");
	 	}
	 	
	 	// @AfterMethod(alwaysRun = true)
		    public void closeBrowser() {
		        driver.quit();
		    }

}

