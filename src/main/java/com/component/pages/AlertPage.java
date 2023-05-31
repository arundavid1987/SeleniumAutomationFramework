/**
 * 
 */
package com.component.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

/**
 * @author Hajeera.bilal
 *
 */
public class AlertPage {
	public WebDriver driver;
	ReusableComponents reusableComponents;
	public AlertPage(WebDriver driver) {
		 this.driver=driver;
		 
	 }
	 public AlertPage initElements() {		 
			return PageFactory.initElements(this.driver, AlertPage.class);
		}
	
	@FindBy(xpath = "//span[@id='button1']")
	public   WebElement javaScriptAlert;

	@FindBy(xpath = "//span[@id='button2']")	
	public   WebElement modalPopup;
	
	@FindBy(xpath = "//span[@id='button3']")
	public   WebElement ajaxLoader;

	@FindBy(xpath = "//span[@id='button4']")	
	public   WebElement javaScriptConfirmBox;

	
	public void handleAlert() {
		 reusableComponents =new ReusableComponents(driver);
		javaScriptAlert.click();
		reusableComponents.alertAccept();
		
	}
	
	public void handleModalPopup() {
		 reusableComponents =new ReusableComponents(driver);
		modalPopup.click();
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		reusableComponents.switchWindow(subWindowHandler);
		 
		WebElement modalpopUpClose = driver.findElement(By.xpath("(//button[@data-dismiss='modal'])[2]"));
		modalpopUpClose.click();

	}
	
	public void ajxxLoader() {
		 reusableComponents =new ReusableComponents(driver);
		 String subWindowHandler = null;
		 ajaxLoader.click();
		WebElement loaderButton = new WebDriverWait(driver, Duration.ofSeconds(240))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='CLICK ME!']")));
		loaderButton.click();
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> iterator1 = handles1.iterator();
		while (iterator1.hasNext()) {
			subWindowHandler = iterator1.next();
		}
		reusableComponents.switchWindow(subWindowHandler);
		reusableComponents.navigateBack();

		// JavaScript Confirm Box
	 javaScriptConfirmBox.click();
		//reusableComponents.alertAccept();
		reusableComponents.alertAccept();
		String message = driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).getText();
		System.out.println(message);
	}

}
