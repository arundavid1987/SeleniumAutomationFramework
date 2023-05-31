/**
 * 
 */
package com.component.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hm.selenium.ReusableComponents;

/**
 * @author Manas.parhi
 *
 */
public class JavaScriptPage {
	public WebDriver driver;
	ReusableComponents reusableComponents;
	
	public JavaScriptPage(WebDriver driver) {
		 this.driver=driver;
		 
	 }
	 public JavaScriptPage initElements() {		 
			return PageFactory.initElements(this.driver, JavaScriptPage.class);
		}
	
	@FindBy(xpath = "//button[@id='onblur']")
	public   WebElement onBlur;

	@FindBy(xpath = "//button[@id='onclick']")
	public   WebElement onClick;

	@FindBy(xpath = "//button[@id='oncontextmenu']")
	public   WebElement onContextMenu;

	@FindBy(xpath = "//button[@id='ondoubleclick']")
	public   WebElement onDoubleClick;

	@FindBy(xpath = "//button[@id='onfocus']")
	public   WebElement onFocus;

	@FindBy(xpath = "//button[@id='onkeydown']")
	public   WebElement onKeyDown;

	@FindBy(xpath = "//button[@id='onkeyup']")
	public   WebElement onKeyUp;

	@FindBy(xpath = "//button[@id='onkeypress']")
	public   WebElement onKeyPress;

	@FindBy(xpath = "//button[@id='onmouseover']")
	public   WebElement onMouseOver;

	@FindBy(xpath = "//button[@id='onmouseleave']")
	public   WebElement onMouseLeave;

	@FindBy(xpath = "//button[@id='onmousedown']")
	public   WebElement onMouseDown;

	@FindBy(xpath = "//h1[contains(.,'JavaScript Events')]")
	public   WebElement jsEvents;


	public void clickOnBlur() {
		onBlur.click();
	}
	
	public void clickOnClick() {
		onClick.click();
	}
	
	public void onContextMenuClick() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.contextClick(onContextMenu);
	}
	
	public void onDoubleClick() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.doubleClick(onDoubleClick);
	}
	
	public void onHover() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.hover(onFocus);
	}
	
	public void onKeyDown() {
		 onKeyDown.sendKeys();
		new Actions(driver)
        .keyDown(Keys.SHIFT)
        .sendKeys("a")
        .perform();
	}
	
	public void onKeyUp() {
		 onKeyUp.sendKeys();
		new Actions(driver)
        .keyDown(Keys.SHIFT)
        .sendKeys("a")
        .keyUp(Keys.SHIFT)
        .sendKeys("b")
        .perform();
	}
	
	public void onKeyPress() {
		 onKeyPress.sendKeys(Keys.ENTER);
	}
	
	public void onMouseOver() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.hover(onMouseOver);
	}
	
	public void onMouseClick() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.mouseClick(onMouseLeave);
	}
	public void onMousedown() {
		 reusableComponents =new ReusableComponents(driver);
		 
			reusableComponents.hover(onMouseDown);
	}
	
}
