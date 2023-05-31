package com.component.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class ScrollBarsPage {
	public WebDriver driver;
	ReusableComponents reusableComponents;
	public JavascriptExecutor js;
	public WebDriverWait waittime;
	public ScrollBarsPage(WebDriver driver) {
		 this.driver=driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }

	 public ScrollBarsPage initElements() {		 
			return PageFactory.initElements(this.driver, ScrollBarsPage.class);
	 }	
		
	public void scrollDown() throws Exception{
		 reusableComponents =new ReusableComponents(driver);
			 
			reusableComponents.scrollDown(5);
		 
	}
	
	public void scrollUp() throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.scrollUp(3);
		 
	}
	
	
	
	
}
