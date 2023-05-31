package com.component.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabPage {
	public WebDriver driver;
	 
	public TabPage(WebDriver driver) {
		this.driver = driver;
	}

	public TabPage initElements() {

		return PageFactory.initElements(this.driver, TabPage.class);
	}
	
	
	@FindBy(xpath = "//nav[@class='nav nav-tabs']/a[1]")
	public   WebElement firstTab;

	@FindBy(xpath = "//nav[@class='nav nav-tabs']/a[2]")
	public   WebElement secondTab;
	
	@FindBy(xpath = "//nav[@class='nav nav-tabs']/a[3]")
	public   WebElement thirdTab;
	
	@FindBy(xpath = "//nav[@class='nav nav-tabs']/a[4]")
	public   WebElement fourthTab;
	
public void handleTabs() throws Exception {
	WebElement isDisabled = driver.findElement(By.xpath("//nav[@class='nav nav-tabs']/a[@aria-disabled='true']"));
	try {

	// firstTab
	 firstTab.click();
	Thread.sleep(5000);
	 
	// secondTab
	 secondTab.click();
	Thread.sleep(5000);
	// thirdTab
	 thirdTab.click();
	Thread.sleep(5000);
	// fourthTab
	 fourthTab.click();
	Thread.sleep(5000);
}
	catch(ElementClickInterceptedException e)
	
	{
		String disabledTab = isDisabled.getText();
		System.out.println("Given tab :" +disabledTab + " is diabled..So user cannot click on it");
}
}
}
