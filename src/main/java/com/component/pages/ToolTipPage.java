package com.component.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hm.selenium.ReusableComponents;

public class ToolTipPage {
	
	 public WebDriver driver;
	 ReusableComponents reusableComponents;
	 
	 public ToolTipPage(WebDriver driver) throws Exception {
		 this.driver=driver;
	 
	 }
	
	
 
	 public ToolTipPage initElements() {
		 
			return PageFactory.initElements(this.driver, ToolTipPage.class);
		}
	

	
	@FindBy(xpath = "//button[@id='toolTipButton']")
	private WebElement HoverButtonElement;
	
	
	@FindBy(xpath = "//input[@id='toolTipTextField']")
	private WebElement HoverTextFieldElement;
	
	
	@FindBy(xpath = "//a[text()='Contrary']")
	private WebElement HoverAlphabeticLinkElement;
	
	@FindBy(xpath = "//a[text()='1.10.32']")
	private WebElement HoverNumericLinkElement;
	
	@FindBy(xpath = "//div[@role='tooltip']/div[@class='arrow']/following::div[@class='tooltip-inner']")
	private WebElement ToolTip;
 
	
	 public void HoverButton(String actualTooltipTxt) throws Exception{
		  reusableComponents =new ReusableComponents(driver);
		 Thread.sleep(2000);
		 reusableComponents.scrollIntoView(HoverButtonElement);
		 reusableComponents.hover(HoverButtonElement);	
		 
		 Thread.sleep(5000);
		 String ExpectedButtonToolTip = ToolTip.getText();
		 System.out.println("ToolTipText of Button-->"+ExpectedButtonToolTip);
		 reusableComponents.AssertEquals(actualTooltipTxt, ExpectedButtonToolTip);
	 
		 
		}
	 
	 public void HoverTextField(String actualTooltipTxt) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.scrollIntoView(HoverTextFieldElement);
		 reusableComponents.hover(HoverTextFieldElement);			 
		 Thread.sleep(5000);
		 String ExpectedButtonToolTip = ToolTip.getText();
		 System.out.println("ToolTipText of TextField-->"+ExpectedButtonToolTip); 
		 reusableComponents.AssertEquals(actualTooltipTxt, ExpectedButtonToolTip);
	 }
	 
	 public void HoverAlphabeticLink(String actualTooltipTxt) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.scrollIntoView(HoverAlphabeticLinkElement);
		 reusableComponents.hover(HoverAlphabeticLinkElement);	
		 
		 Thread.sleep(5000);
		 String ExpectedButtonToolTip = ToolTip.getText();
		 System.out.println("ToolTipText of Alphabetic Link-->"+ExpectedButtonToolTip);
		 reusableComponents.AssertEquals(actualTooltipTxt, ExpectedButtonToolTip);
	 
	 }
	 
	 public void HoverNumericLink(String actualTooltipTxt) throws Exception{
		
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.scrollIntoView(HoverNumericLinkElement);
		 reusableComponents.hover(HoverTextFieldElement);		  
		 String ExpectedButtonToolTip = ToolTip.getText();
		 System.out.println("ToolTipText of Numeric Link-->"+ExpectedButtonToolTip);
		 reusableComponents.AssertEquals(actualTooltipTxt, ExpectedButtonToolTip);
		 
	 }
	 
	 

}
