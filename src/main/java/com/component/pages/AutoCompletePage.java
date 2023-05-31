package com.component.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoCompletePage {
	
	public WebDriver driver;
	public WebDriverWait waittime;
	
	public AutoCompletePage(WebDriver driver) {
		this.driver= driver;
		waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public AutoCompletePage initElements() {		 
		return PageFactory.initElements(this.driver, AutoCompletePage.class);
	}
	
	@FindBy(xpath = "//input[@id='autoCompleteMultipleInput']")
	private WebElement colorbox;
		
	@FindBy (id = "autoCompleteSingleInput")
	private WebElement colorbox1;
	
	@FindBy (xpath ="//div[@id='autoCompleteSingleContainer']")
	private WebElement ColorDiv;
	
	public void enterMultiColor() {
	 	String multiColor = "Blue,Black";
	 	
		 try {
			  ArrayList<String> colorList = new ArrayList<>(Arrays.asList(multiColor.split(",")));
			  for (int i =0; i<colorList.size();i++) 
			  	{
				  colorbox.sendKeys(colorList.get(i));
				  Thread.sleep(200);
				  List<WebElement> options = colorbox.findElements(By.xpath("//div[contains(@class, 'auto-complete__menu')]"));
				  if(options.size()>0) { 
					  for(WebElement option: options) 
					  	{
						  if(option.getText().toString().equalsIgnoreCase(colorList.get(i))) 
					 		{
							  System.out.println("selecting text "+colorList.get(i));
							  option.click();
							  break;
					 		}
					  	}
				  }
				  else {
					System.out.println("No suggestion found to auto complete");
				  }
			  	} 
			 
			
		 	}
		 catch(Exception e) 
		 {
			 System.out.println(e.getStackTrace());
		 }	
	}
	
	public void enterSingleColor() {
			String singleColor = "red";
			try {
				System.out.println("in test 2");
				colorbox1.click();
				Thread.sleep(500);
				colorbox1.sendKeys("red");
				Thread.sleep(1000);
				List<WebElement> options =  ColorDiv.findElements(By.xpath("//div[contains(@class, 'auto-complete__menu')]"));
				if(options.size()>0) {
					for(WebElement option: options) 
						{
						System.out.println(option.getText().toString());
					 	if(option.getText().toString().equalsIgnoreCase(singleColor)) 
					 		{
					 		System.out.println("selecting text "+option.getText().toString());
					 		option.click();
				 			break;
					 		}
						}
				}
			
			else {
				System.out.println("No suggestion found to autocomplete");
				}
		 	
		 }
		
		 catch(Exception e) {
			 System.out.println(e.getStackTrace());
		 }
		 

	}
		
}
