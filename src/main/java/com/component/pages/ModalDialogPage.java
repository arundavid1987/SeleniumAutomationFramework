package com.component.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hm.selenium.ReusableComponents;

public class ModalDialogPage {
	
	 public WebDriver driver;
	 ReusableComponents reusableComponents;
	 public ModalDialogPage(WebDriver driver) {
		 this.driver=driver;
	 }
 
	 public ModalDialogPage initElements() {
		 
			return PageFactory.initElements(this.driver, ModalDialogPage.class);
		}
	 
	@FindBy(xpath = "//button[@id='showSmallModal']")
	private WebElement SmallModalButton;
	
	@FindBy(xpath = "//button[@id='showLargeModal']")
	private WebElement LargeModalButton;	
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement ContentOfModalDialog;	
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement CloseButton;
	
	@FindBy(xpath="//button[@class='close']")
	private WebElement xButton;	
	
	public void GetSmallModalDialogText(String ActualText) throws Exception{
		reusableComponents =new ReusableComponents(driver);
		 	SmallModalButton.click(); 
			Thread.sleep(5000);
			String Content=ContentOfModalDialog.getText();
			System.out.println("Content of Small Modal "+Content);
			reusableComponents.AssertEquals(ActualText, Content);			 
			CloseButton.click();		 
			Thread.sleep(3000);
		}
	
	public void GetLargeModalDialogText(String ActualText) throws Exception{
		reusableComponents =new ReusableComponents(driver);
		LargeModalButton.click(); 
		Thread.sleep(5000);
		String Content=ContentOfModalDialog.getText();
		System.out.println("Content of Large Modal "+Content);
		reusableComponents.AssertEquals(ActualText, Content);		 
		xButton.click();		 
		Thread.sleep(3000);

	}

}
