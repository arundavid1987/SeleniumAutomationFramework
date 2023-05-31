package com.component.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import hm.selenium.ReusableComponents;

public class CanvasPage {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;
	ReusableComponents reusableComponents;
	public CanvasPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		waittime = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public CanvasPage initElements() {
		return PageFactory.initElements(this.driver, CanvasPage.class);
	}
	
	@FindBy(name = "clearbutton")
	private WebElement clearButton;
	
	@FindBy(id = "xnum")
	private WebElement xNum;
	
	@FindBy(id = "ynum")
	private WebElement yNum;
	
	@FindBy(id = "shapesize")
	private WebElement shapeSize;
	
	@FindBy(id = "colourselect")
	private WebElement shapeColour;
	
	@FindBy(id = "shapeselect")
	private WebElement objShape;
	
	@FindBy(name = "gobutton")
	private WebElement showButton;
	
	@FindBy(id = "commands")
	private WebElement commandList;
	
	@FindBy(id = "canvas")
	private WebElement canvasBox;	
	
	public void highlight(WebElement element) throws Exception{
		
		waittime.until(ExpectedConditions.visibilityOf(element));
		for (int i = 0; i < 2; i++)
		{

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");

			Thread.sleep(500);

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			Thread.sleep(500);

		}
	}
	
	public void drawShape(String instruction) throws Exception {
		
		Thread.sleep(2000);
		  reusableComponents =new ReusableComponents(driver);
			
			Thread.sleep(2000);
			reusableComponents.highlightWebElement(clearButton);
		 
		clearButton.click();
		Thread.sleep(2000);
		
		String[] instructionParams = instruction.split(";");
		String xCO = instructionParams[0];
		String yCO = instructionParams[1];
		String size = instructionParams[2];
		String color = instructionParams[3];
		String shape = instructionParams[4];
		reusableComponents.highlightWebElement(xNum);
		 
		xNum.clear();
		xNum.sendKeys(xCO);
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(yNum);
		reusableComponents.scrollIntoView(yNum);
		 
		yNum.clear();
		yNum.sendKeys(yCO);
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(shapeSize);
		 
		shapeSize.clear();
		shapeSize.sendKeys(size);
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(shapeColour);
	 
		final Select colorList = new Select(shapeColour);
		List<WebElement> colorOptions = colorList.getOptions();
		for (WebElement optionText : colorOptions) 
		{			
			if (optionText.getText().equals(color)) 
			{
				System.out.println(optionText.getText());
				optionText.click();
				break;
			}
		}
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(objShape);
		 
		final Select shapeList = new Select(objShape);
		List<WebElement> shapeOptions = shapeList.getOptions();
		for (WebElement optionText : shapeOptions) 
		{			
			if (optionText.getText().equals(shape)) 
			{
				System.out.println(optionText.getText());
				optionText.click();
				break;
			}
		}		
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(showButton);
	 
		showButton.click();
		Thread.sleep(2000);
		reusableComponents.scrollIntoView(commandList);
	 
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(commandList);
	 
		Thread.sleep(2000);
		reusableComponents.highlightWebElement(canvasBox);
		 
		Thread.sleep(2000);
	}

}
