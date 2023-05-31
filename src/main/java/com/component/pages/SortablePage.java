package com.component.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class SortablePage {
	public WebDriver driver;
	public WebDriverWait waittime;
	 static ReusableComponents reusableComponents;
	public SortablePage(WebDriver driver) {
		 this.driver=driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }

	 public SortablePage initElements() {		 
			return PageFactory.initElements(this.driver, SortablePage.class);
		}
	 @FindBy(id = "demo-tab-grid")
	 private WebElement gridTab;
	 
	 @FindBy(id="demo-tab-list")
	 private WebElement listTab;
	 
	 @FindBy(className="create-grid")
	 private WebElement gridTable;
	 
	 @FindBy(css=".vertical-list-container.mt-4")
	 private WebElement listTable;
	 
	 public void sortList(String listOrder) throws Exception{
			listTab.click();
			String[] list=listOrder.split(";");
			int size=list.length;
			for(int i=size-1;i>=0;i--)
			{
				performSort(listTable,driver,list[i]);			
			}
		}
	 public void sortGrid(String GridOrder) throws Exception{
			gridTab.click();
			String[] list=GridOrder.split(";");
			int size=list.length;
			for(int i=size-1;i>=0;i--)
			{
				performSort(gridTable,driver,list[i]);			
			}
		}
	 public void sortThird(String GridOrder) throws Exception{
			gridTab.click();
			String[] list=GridOrder.split(";");
			int size=list.length;
			for(int i=size-1;i>=0;i--)
			{
				performSort(gridTable,driver,list[i]);			
			}
		}
	 public static void performSort(WebElement mainElement,WebDriver driver,String value) throws Exception
		{
		     
			List<WebElement> children = mainElement.findElements(By.xpath("./child::*"));
			int index=0;
			for(int i=0;i<children.size();i++)
			{
				if(children.get(i).getText().equalsIgnoreCase(value))
				{
					 index=i;
				}
			}
			if(index!=0)
			{
				WebElement fromElement = children.get(index);
				WebElement toElement = children.get(0);
				Actions builder = new Actions(driver);
				builder.clickAndHold(fromElement).release(toElement).perform();	
				 
			}
			else
			{
				throw new Exception("Given value not found in the table");
			}
			
		}
}
