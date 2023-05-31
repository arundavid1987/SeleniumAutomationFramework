/**
 * 
 */
package com.component.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import hm.selenium.ReusableComponents;

/**
 * @author Manas.parhi
 *
 */
public class WaitPage {
	public WebDriver driver;
	ReusableComponents reusableComponents;
	
	public WaitPage(WebDriver driver) {
		 this.driver=driver;
		 
	 }
	 public WaitPage initElements() {		 
			return PageFactory.initElements(this.driver, WaitPage.class);
		}
	
	@FindBy(css = "button#accept.button.is-link")
	public   WebElement SimpleAlert;
	
	public void simpleAlert() {
		SimpleAlert.click();
	}
	
	public void handleAlert() {
		Alert alert = driver.switchTo().alert();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String t = alert.getText();		 
		System.out.println("Alert text displayed: " + t);
		alert.accept();

		driver.switchTo().defaultContent();
	}
	
}
