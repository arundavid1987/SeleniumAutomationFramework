package com.component.pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hm.selenium.ReusableComponents;

public class ButtonPage {

	public WebDriver driver;
	ReusableComponents reusableComponents;
	public ButtonPage(WebDriver driver) {
		this.driver = driver;
	}

	public ButtonPage initElements() {

		return PageFactory.initElements(this.driver, ButtonPage.class);
	}
	
	@FindBy(xpath = "//div[@class='control']/button[text()='Goto Home']")
	public   WebElement goToHomeButton;

	@FindBy(xpath = "//div[@class=\"control\"]/button[text()='Find Location']")
	public   WebElement findLocationButton;

	

	@FindBy(xpath = "//div[@class=\"control\"]/button[text()='What is my color?']")
	public   WebElement colorButton;


	@FindBy(xpath = "//div[@class=\"control\"]/button[text()='How tall & fat I am?']")
	public   WebElement sizeButton;
	
	@FindBy(xpath = "//div[@class=\"control\"]/button[text()='Disabled']")
	public   WebElement disabledButton;

	@FindBy(xpath = "//div[@class=\"control\"]/button[@id='isDisabled']/div/h2")
	public   WebElement holdButton;
	
	
	
	public void goToHomePage() throws Exception {
		 goToHomeButton.click();
		Thread.sleep(5000);
	}
	
	public void getLocation() {
		reusableComponents =new ReusableComponents(driver);
		Point xypoint = reusableComponents.getLocation(findLocationButton);		 
		int xvalue = xypoint.getX();
		int yvalue = xypoint.getY();
		System.out.println(" X value is :" + xvalue);
		System.out.println(" Y value is :" + yvalue);
	}
	
	public void getBackgroundColor() {
		reusableComponents =new ReusableComponents(driver);
		String colorofButton  = reusableComponents.getBackgroundColor(colorButton);	
		System.out.println("button color is :" + colorofButton);
	}
	
	public void getSize() {
		reusableComponents =new ReusableComponents(driver);
		int height = reusableComponents.getHeight(sizeButton);
		int width = reusableComponents.getWidth(sizeButton);
		System.out.println("Height of the button is :" + height);
		System.out.println("Height of the button is :" + width);
	}
	
	public void isElementEnabled() {
		reusableComponents =new ReusableComponents(driver);
		Boolean isEnabled= reusableComponents.isElementEnabled(disabledButton);		 
		if (isEnabled == false) {
			System.out.println("Button is Disabled");
		} else {
			System.out.println("Button is Enabled");

		}
	}
	
	 
}


