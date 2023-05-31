package com.component.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class DynamicElementsPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;
	ReusableComponents reusableComponents;
	public DynamicElementsPage(WebDriver driver) {
		 this.driver=driver;
		 js = (JavascriptExecutor) driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }

	 public DynamicElementsPage initElements() {		 
			return PageFactory.initElements(this.driver, DynamicElementsPage.class);
		}	
	 
	
	@FindBy(id = "enableAfter")
	private WebElement firstElement;
	
	@FindBy(id = "colorChange")
	private WebElement secondElement;
	
	@FindBy(id = "visibleAfter")
	private WebElement thirdElement;
		
	 
		
	public String[] verifyElementEnabled() throws Exception{
		 reusableComponents =new ReusableComponents(driver);
 	
		String[] propValues= new String[2];
		reusableComponents.refresh();
		propValues[0]=String.valueOf(firstElement.isEnabled());
		Thread.sleep(5000);
		reusableComponents.highlightWebElement(firstElement);
		propValues[1]=String.valueOf(firstElement.isEnabled());
		return propValues;		
	}
	
	public String[] verifyElementPropertyChange() throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		String[] propValues= new String[2];
		reusableComponents.refresh();
		propValues[0]=String.valueOf(secondElement.getAttribute("class"));
		Thread.sleep(5000);
		reusableComponents.highlightWebElement(secondElement);
		propValues[1]=String.valueOf(secondElement.getAttribute("class"));
		return propValues;		
	}
	
	public String[] verifyElementDisplayed() throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		String[] propValues= new String[2];
		reusableComponents.refresh();
		try
		{
			thirdElement.isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			propValues[0]="false";
		}		
		Thread.sleep(5000);
		reusableComponents.highlightWebElement(thirdElement);
		propValues[1]=String.valueOf(thirdElement.isDisplayed());
		return propValues;		
	}
	
	
}
