package com.component.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class MultipleTabPage {

	public WebDriver driver;
	public WebDriverWait waittime;
	 ReusableComponents reusableComponents;
	public MultipleTabPage(WebDriver driver) {
		this.driver= driver;
		waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public MultipleTabPage initElements() {		 
		return PageFactory.initElements(this.driver, MultipleTabPage.class);
	}
	
	@FindBy(id = "tabButton")
	private WebElement newTab;
	
	@FindBy (id = "windowButton")
	private WebElement newWindow;
	
	@FindBy (id="messageWindowButton")
	private WebElement newWindowMessage;
	
	
	public void getNewTabAndClose() throws InterruptedException {
		  reusableComponents =new ReusableComponents(driver);
		ArrayList<String> tabs1 = reusableComponents.getWindowHanldes();
		System.out.println(tabs1.size());
		driver.switchTo().window(tabs1.get(1));
		System.out.println("inside new tab  ");
		Thread.sleep(1000);
		driver.close();
		System.out.println("closed new tab");
		driver.switchTo().window(tabs1.get(0));
		System.out.println("switched to old tab  ");
		Thread.sleep(3000);
	
	}
	
	public void openNewTab() {
		newTab.click();
		System.out.println("clicked new tab");
	}
	
	public void openNewWindow() {
		newWindow.click();
		System.out.println("clicked new window");
	}
	
	public void openNewWindowMessage() {
		newWindowMessage.click();
		System.out.println("clicked new window message");
	}

}