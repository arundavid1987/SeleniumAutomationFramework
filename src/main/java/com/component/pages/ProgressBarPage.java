package com.component.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hm.selenium.ReusableComponents;

public class ProgressBarPage {


    public WebDriver driver;
    public WebDriverWait wait;

    public ProgressBarPage(WebDriver driver) throws Exception {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public ProgressBarPage initElements() {
        return PageFactory.initElements(this.driver, ProgressBarPage.class);
    }
    ReusableComponents reusableComponents;
    @FindBy(xpath = "//*[@id='progressbar0']")
    private WebElement Task1Progressbar;

    @FindBy(xpath = "//p[@id='status']")
    private WebElement Statusbar;

    public void WaitForValueInAttribute(String attribute, String value) throws Exception {
    	 reusableComponents =new ReusableComponents(driver);
        Boolean b = wait.until(ExpectedConditions.attributeToBe(Task1Progressbar, attribute, value));
        reusableComponents.AssertTrue(b);
        String actualAttribute = Task1Progressbar.getAttribute(attribute);
        reusableComponents.AssertEquals(actualAttribute, value);
  
    }

    public void WaitForText(String expectedText){
    	 reusableComponents =new ReusableComponents(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(Statusbar, expectedText));
        String processStatus = Statusbar.getText();
        reusableComponents.AssertEquals(processStatus, expectedText);
  
    }

}
