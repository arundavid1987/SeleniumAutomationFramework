package com.component.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownloadPage {
	public WebDriver driver;
	public WebDriverWait waittime;

	public FileDownloadPage(WebDriver driver) {
		 this.driver=driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }
	
	 public FileDownloadPage initElements() {		 
			return PageFactory.initElements(this.driver, FileDownloadPage.class);
		}
	 @FindBy(className = "example")
	 private WebElement mainElement;
	 
	 public void downloadFiles(String Filename) throws Exception{
		 List<WebElement> children=mainElement.findElements(By.xpath("./child::*"));
		 for(int i=0;i<children.size();i++)
			{
				if(children.get(i).getText().equalsIgnoreCase(Filename))
				{
					 children.get(i).click();
				}
			}
		  
	 }
}
