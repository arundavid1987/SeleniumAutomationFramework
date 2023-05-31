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

public class JqueryUIMenuPage {

	public WebDriver driver;
	ReusableComponents reusableComponents;
	public JqueryUIMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public JqueryUIMenuPage initElements() {

		return PageFactory.initElements(this.driver, JqueryUIMenuPage.class);
	}

	@FindBy(xpath = "//*[@id=\"ui-id-3\"]")
	private WebElement uiElement1;

	@FindBy(xpath = "//*[@id=\"ui-id-4\"]")
	private WebElement uiElement2;

	public void hoverOnElement() {
		reusableComponents =new ReusableComponents(driver);	
		reusableComponents.hover(uiElement1);
		 WebElement element =reusableComponents.waitForVisibilityOfElementLocated("//*[@id=\"ui-id-4\"]");
		 reusableComponents.hover(uiElement2);
 

	}

}
