package com.component.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateElementExistPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;

	public ValidateElementExistPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		waittime = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public ValidateElementExistPage initElements() {
		return PageFactory.initElements(this.driver, ValidateElementExistPage.class);
	}

	@FindBy(xpath = "//li[5]/a")

	private WebElement elementExist;

	public void elementExist() throws Exception {

		List<WebElement> Element = driver.findElements(By.xpath("//li[5]/a"));
		if (Element.size() == 0) {
			System.out.println("Element not Exist on page load");
		} else {
			System.out.println("Element Exist on page load");
		}
	}

}
