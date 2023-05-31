package com.component.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderPage {
	public WebDriver driver;
	public CalenderPage(WebDriver driver) {
		 this.driver=driver;
		 
	 }
	 public CalenderPage initElements() {		 
			return PageFactory.initElements(this.driver, CalenderPage.class);
		}
	
	@FindBy(xpath = "//input[@class='datetimepicker-dummy-input is-datetimepicker-range']")
	public   WebElement todayBar;

	@FindBy(xpath = "(//button[@class='date-item is-today'])[2]")
	public   WebElement todaysDate;
	
	public void handleCalendar() throws Exception {
		 todayBar.click();
		Thread.sleep(5000);
		int currentDate = Integer.parseInt( todaysDate.getText());

		 todaysDate.click();

		Thread.sleep(5000);
	 
		int endDate = currentDate + 3;
		Thread.sleep(5000);

		driver.findElement(By.xpath("(//button[text()= " + endDate + "])[2]")).click();
	}

}
