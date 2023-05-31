/**
 * 
 */
package com.component.testcases.withjar;


import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.component.pages.AlertPage;
import com.component.pages.JavaScriptPage;
import com.component.pages.ToolTipPage;
import com.utils.ExcelReader;
import com.utils.ExtentListeners;
import com.utils.setupdriver.SetupTestDriver;

/**
 * @author Manas.parhi
 *
 */
public class JavaScriptEventTest {

	public WebDriver driver;
	ExtentListeners objExtentListeners = new ExtentListeners();
	JavaScriptPage objJavaScriptPage;
	 @BeforeMethod(alwaysRun = true)
	 @Parameters({"browser", "urlJavascriptEvent"})
	public void setupBrowser(String browser, String url) throws Exception {
	 
		 SetupTestDriver setupTestDriver = new SetupTestDriver(browser, url);
	        this.driver = setupTestDriver.getDriver();	
	         
	}
 

	@Test
	public void jsEventHandling() throws InterruptedException {
		objJavaScriptPage  = new JavaScriptPage(driver).initElements();
		ExtentTest etest = objExtentListeners.getTest().get();

		// Handling JavaScript event - onBlur
		objJavaScriptPage.clickOnBlur();		 
		etest.log(Status.PASS, "OnBlur event triggered successfully");
		System.out.println("OnBlur event triggered successfully");
		
		// Handling JavaScript event - onClick
		objJavaScriptPage.clickOnClick();	
		etest.log(Status.PASS, "OnClick event triggered successfully");
		System.out.println("OnClick event triggered successfully");

		// Handling JavaScript event - onContextMenu
		objJavaScriptPage.onContextMenuClick();
		etest.log(Status.PASS, "OnContextMenu event triggered successfully");
		System.out.println("OnContextMenu event triggered successfully");
		
		// Handling JavaScript event - onDoubleCick
		objJavaScriptPage.onDoubleClick();
		etest.log(Status.PASS, "OnDoubleClick event triggered successfully");
		System.out.println("OnDoubleClick event triggered successfully");
		
		// Handling JavaScript event - onFocus
		objJavaScriptPage.onHover();
		etest.log(Status.PASS, "onFocus event triggered successfully");
		System.out.println("onFocus event triggered successfully");
		
		// Handling JavaScript event - onKeyDown
		objJavaScriptPage.onKeyDown();
		etest.log(Status.PASS, "onKeyDown event triggered successfully");
		System.out.println("onKeyDown event triggered successfully");
		
		// Handling JavaScript event - onKeyUp
		objJavaScriptPage.onKeyUp();
		etest.log(Status.PASS, "onKeyUp event triggered successfully");
		System.out.println("onKeyUp event triggered successfully");
		
		// Handling JavaScript event - onKeyPress
		objJavaScriptPage.onKeyPress();
		etest.log(Status.PASS, "onKeyPress event triggered successfully");
		System.out.println("onKeyPress event triggered successfully");
		
		// Handling JavaScript event - onMouseOver
		objJavaScriptPage.onMouseOver();
		etest.log(Status.PASS, "onMouseOver event triggered successfully");
		System.out.println("onMouseOver event triggered successfully");
		
		// Handling JavaScript event - onMouseLeave
		objJavaScriptPage.onMouseClick();
		etest.log(Status.PASS, "onMouseLeave event triggered successfully");
		System.out.println("onMouseLeave event triggered successfully");
		
		// Handling JavaScript event - onMouseDown
		objJavaScriptPage.onMousedown();
		 
		etest.log(Status.PASS, "onMouseDown event triggered successfully");
		System.out.println("onMouseDown event triggered successfully");

	}


	@AfterMethod(alwaysRun = true)
	public void tearDown() { 
		driver.quit(); 
	}


}
