package com.retail.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirebasePage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;

	public FirebasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	}

	public FirebasePage initElements() {

		return PageFactory.initElements(this.driver, FirebasePage.class);
	}

	@FindBy(xpath = "//span[.='Cart']/preceding-sibling::div/div")
	private WebElement bagQuantity;

	@FindBy(xpath = "//button[.='Checkout']")
	private WebElement checkoutButton;

	@FindBy(xpath = "//p[contains(.,'Add some products in the cart')]")
	private WebElement emptyCartMessage;

	@FindBy(xpath = "//span[.='X']/parent::button")
	private WebElement closeCartButton;
	
	public void highlight(WebElement element) throws Exception{
		waittime.until(ExpectedConditions.visibilityOf(element));
		for (int i = 0; i < 2; i++)
		{

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");

			Thread.sleep(500);

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			Thread.sleep(500);

		}
	}

	public void selectSize(String sizeName) throws Exception {
		Thread.sleep(2000);
		String sizeXpath = "//span[.=\"" + sizeName + "\"]";
		WebElement sizeButton = driver.findElement(By.xpath(sizeXpath));
		highlight(sizeButton);
		sizeButton.click();
	}

	public boolean addToCart(String productName) throws Exception {
		Thread.sleep(2000);
		String productXpath = "//div/p[contains(.,'"+productName+"')]/following-sibling::button[.='Add to cart']";
		WebElement addToCartButton = driver.findElement(By.xpath(productXpath));
		highlight(addToCartButton);
		addToCartButton.click();
		
		Thread.sleep(2000);
		String itemXpath = "//button[contains(@title,'remove product from cart')]/following-sibling::div/p[contains(.,'"+productName+"')]";
		WebElement shelfItem = driver.findElement(By.xpath(itemXpath));
		highlight(shelfItem);
		boolean itemDisplayed = shelfItem.isDisplayed();
		
		Thread.sleep(2000);
		boolean quantityAdded;
		highlight(bagQuantity);
		if (Integer.parseInt(bagQuantity.getText()) == 1)
			quantityAdded = true;
		else
			quantityAdded = false;
		if (itemDisplayed && quantityAdded)
			return true;
		else
			return false;
	}

	public boolean checkout(String alertText) throws Exception {
		Thread.sleep(2000);
		highlight(checkoutButton);
		checkoutButton.click();
		
		Thread.sleep(2000);
		Alert objAlert = driver.switchTo().alert();
		String objAlertText = objAlert.getText();
		if (objAlertText.contains(alertText)) {
			objAlert.accept();
			return true;
		} else {
			objAlert.accept();
			return false;
		}
	}

	public boolean removeFromCart(String productName) throws Exception {
		Thread.sleep(2000);
		String productXpath = "//img[@alt='"+productName+"']/preceding-sibling::button";
		WebElement removFromCartButton = driver.findElement(By.xpath(productXpath));
		highlight(removFromCartButton);
		removFromCartButton.click();
		
		Thread.sleep(2000);
		highlight(emptyCartMessage);
		boolean itemDisplayedNA = emptyCartMessage.isDisplayed();
		
		Thread.sleep(2000);
		highlight(bagQuantity);
		boolean quantityRemoved;
		if (Integer.parseInt(bagQuantity.getText()) == 0)
			quantityRemoved = true;
		else
			quantityRemoved = false;
		if (itemDisplayedNA && quantityRemoved)
			return true;
		else
			return false;
	}

	public void closeCart() throws Exception {
		Thread.sleep(2000);
		highlight(closeCartButton);
		closeCartButton.click();
	}
}
