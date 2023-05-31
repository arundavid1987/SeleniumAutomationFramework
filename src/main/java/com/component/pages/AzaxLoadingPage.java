package com.component.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hm.selenium.ReusableComponents;

public class AzaxLoadingPage {

	public WebDriver driver;
	ReusableComponents reusableComponents;
	

	public AzaxLoadingPage(WebDriver driver) {
		this.driver = driver;
	}

	public AzaxLoadingPage initElements() {

		return PageFactory.initElements(this.driver, AzaxLoadingPage.class);
	}

	@FindBy(xpath = "//button[contains(text(),'Start')]")
	private WebElement startLink;
	
	
	
	public String getText() throws Exception {
		startLink.click();
		 reusableComponents =new ReusableComponents(driver);			 
		 WebElement element =reusableComponents.waitForVisibilityOfElementLocated("//h4[contains(text(),'Hello World!')]");
 
		System.out.println(element.getText());

		return element.getText();

	}

}
