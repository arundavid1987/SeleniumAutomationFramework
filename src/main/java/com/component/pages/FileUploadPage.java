package com.component.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class FileUploadPage {
	public WebDriver driver;
	public WebDriverWait waittime;
	 ReusableComponents reusableComponents;
	public FileUploadPage(WebDriver driver) {
		 this.driver=driver;
		 waittime = new WebDriverWait(driver,Duration.ofSeconds(30));
	 }
	
	 public FileUploadPage initElements() {		 
			return PageFactory.initElements(this.driver, FileUploadPage.class);
		}
	 
	 @FindBy(id = "file-upload")
	 private WebElement chooseFile;
	 
	 @FindBy(id="file-submit")
	 private WebElement uploadButton;
	 
	 public void uploadFile(String Filename) throws Exception{
		 reusableComponents =new ReusableComponents(driver);
		 new Actions(driver).click(chooseFile).perform();
		 Thread.sleep(10000);
		 reusableComponents.performUpload(Filename);
		 System.out.println("Successfully Uploaded the File");
		 new Actions(driver).click(uploadButton).perform();
		 // uploadButton.click();
	 }
	 
	 
	  
}
