package com.component.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class DropdownPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;
	 ReusableComponents reusableComponents;
	public DropdownPage(WebDriver driver) {
		 this.driver=driver;
		 js = (JavascriptExecutor) driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }

	 public DropdownPage initElements() {		 
			return PageFactory.initElements(this.driver, DropdownPage.class);
		}
	
	 
	@FindBy(xpath = "//*[@id=\"withOptGroup\"]/div/div[2]")
	private WebElement slctValueDropDown;
	
	final String slctValueOptionPane = "//*[@id=\"withOptGroup\"]/div[2]/div";
	@FindBy(xpath = slctValueOptionPane)
	private WebElement slctValueOption;
	
	@FindBy(id = "selectOne")
	private WebElement slctOneDropDown;
	
	final String slctOneOptionPane = "//*[@id=\"selectOne\"]/div[2]/div/div/div[2]";
	@FindBy(xpath = slctOneOptionPane)
	private WebElement slctOneOption;
	
	@FindBy(id = "oldSelectMenu")
	private WebElement slctOldStyleDropDown;
	
	@FindBy(xpath = "//b[.='Multiselect drop down']/../parent::div")	
	private WebElement multiselectDropDownDiv;
	
	@FindBy(xpath = "//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[2]/div")	
	private WebElement multiselectDropDownOpen;
	
	final String multiselectOptionPane = "//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div[2]/div";
	@FindBy(xpath = multiselectOptionPane)
	private WebElement multiselectOption;
	
	@FindBy(xpath = "//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[2]/div[2]")	
	private WebElement multiselectDropDownClose;
	
	@FindBy(xpath = "//b[.='Standard multi select']/../parent::div")	
	private WebElement stdMultiselectDropDownDiv;
	
	@FindBy(id = "cars")	
	private WebElement stdMultiselectDropDown;
	
	 
		
	public void selectValue(String optionValue) throws Exception{
		  reusableComponents =new ReusableComponents(driver);
		
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(slctValueDropDown);
		Thread.sleep(2000);
		slctValueDropDown.click();
		List<WebElement> optionValues = slctValueOption.findElements(By.xpath(slctValueOptionPane+"//*"));
		for (int i=0;i<optionValues.size();i++)
		{
			if(optionValues.get(i).getText().equals(optionValue))
			{
				System.out.println("Div : " +optionValues.get(i).getText());
				waittime.until(ExpectedConditions.visibilityOf(optionValues.get(i)));
				waittime.until(ExpectedConditions.elementToBeClickable(optionValues.get(i)));
				Thread.sleep(3000);
				System.out.println("Waited");
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", optionValues.get(i));
				System.out.println("Option Selected");
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	public void selectOne(String optionValue) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(slctOneDropDown);
		Thread.sleep(2000);		
		slctOneDropDown.click();
		List<WebElement> optionValues = slctOneOption.findElements(By.xpath(slctOneOptionPane+"//*"));
		for (int i=0;i<optionValues.size();i++)
		{
			if(optionValues.get(i).getText().equals(optionValue))
			{
				System.out.println("Div : " +optionValues.get(i).getText());
				waittime.until(ExpectedConditions.visibilityOf(optionValues.get(i)));
				waittime.until(ExpectedConditions.elementToBeClickable(optionValues.get(i)));
				Thread.sleep(3000);
				System.out.println("Waited");
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", optionValues.get(i));
				System.out.println("Option Selected");
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	public void selectOldMenu(String optionValue) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
			Thread.sleep(2000);
			reusableComponents.highlightWebElement(slctOldStyleDropDown);
		 
		Thread.sleep(2000);
		waittime.until(ExpectedConditions.visibilityOf(slctOldStyleDropDown));
		waittime.until(ExpectedConditions.elementToBeClickable(slctOldStyleDropDown));
		final Select selectList = new Select(slctOldStyleDropDown);
		
		List<WebElement> options = selectList.getOptions();
		for (WebElement optionText : options) 
		{			
			if (optionText.getText().equals(optionValue)) 
			{
				System.out.println(optionText.getText());
				optionText.click();
				break;
			}
		}
		Thread.sleep(2000);
	}
	
	public void multiselectList(String optionValue) throws Exception{
		Thread.sleep(2000);
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.scrollIntoView(multiselectDropDownDiv);
			reusableComponents.highlightWebElement(multiselectDropDownOpen);
 
		Thread.sleep(2000);		
		waittime.until(ExpectedConditions.elementToBeClickable(multiselectDropDownOpen));
		multiselectDropDownOpen.click();
		System.out.println("Dropdown Opened");
		
		String[] splitOptionValues = optionValue.split(";");
		for (int j=0;j<splitOptionValues.length;j++)
		{			
			Thread.sleep(1000);
			List<WebElement> optionValues = multiselectOption.findElements(By.xpath(multiselectOptionPane+"//*"));
			System.out.println("Number of options:"+optionValues.size());
			for (int i=0;i<optionValues.size();i++)
			{
				if(optionValues.get(i).getText().equals(splitOptionValues[j]))
				{
					System.out.println("Div : " +optionValues.get(i).getText());
					waittime.until(ExpectedConditions.visibilityOf(optionValues.get(i)));
					waittime.until(ExpectedConditions.elementToBeClickable(optionValues.get(i)));
					Thread.sleep(3000);
					System.out.println("Waited");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", optionValues.get(i));
					System.out.println("Option Selected");
					Thread.sleep(2000);
					break;
				}
			}
		}
		
		waittime.until(ExpectedConditions.elementToBeClickable(multiselectDropDownClose));
		multiselectDropDownClose.click();
		System.out.println("Dropdown Closed");
		
	}

	public void stdMultiselectList(String optionValue) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		 reusableComponents.scrollIntoView(stdMultiselectDropDownDiv);
		reusableComponents.highlightWebElement(stdMultiselectDropDown);
 
		Thread.sleep(2000);			
		String[] splitOptionValues = optionValue.split(";");
		waittime.until(ExpectedConditions.elementToBeClickable(stdMultiselectDropDown));
		final Select selectList = new Select(stdMultiselectDropDown);
		for (int j=0;j<splitOptionValues.length;j++)
		{			
			List<WebElement> options = selectList.getOptions();
			for (WebElement optionText : options) 
			{			
				if (optionText.getText().equals(splitOptionValues[j])) 
				{
					System.out.println(optionText.getText());
					optionText.click();
					Thread.sleep(2000);
					break;
				}
			}
		}		
	}
	
}
