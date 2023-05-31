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

public class NotificationMessage {

	public WebDriver driver;
	ReusableComponents reusableComponents;
	public NotificationMessage(WebDriver driver) {
		this.driver = driver;
	}

	public NotificationMessage initElements() {

		return PageFactory.initElements(this.driver, NotificationMessage.class);
	}

	@FindBy(xpath = "//*[text()='Click here']")
	private WebElement clickHereLink;

	@FindBy(xpath = "//*[@id=\"flash\"]")
	private WebElement notificationHeader;

	public void getNotificationMessage() {

		clickHereLink.click();
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.waitForVisibilityOfElementLocated("//*[@id='flash']");
		 
		System.out.println(notificationHeader.getText());

	}

}
