package com.component.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SlowLoadIssuePage {

	public WebDriver driver;

	public SlowLoadIssuePage(WebDriver driver) throws Exception {
		this.driver = driver;

	}

	public SlowLoadIssuePage initElements() {

		return PageFactory.initElements(this.driver, SlowLoadIssuePage.class);
	}

	@FindBys({ @FindBy(xpath = "//h3[contains(text(),'Slow Resources')]") })
	private List<WebElement> MultipleSlowResources;

	@FindBy(xpath = "//h3[contains(text(),'Slow Resources')]")
	private WebElement SlowResources;

	public void fnSlowLoadIssue(Integer iExpectedWaitTime, ExtentTest etest) throws Exception {

		Boolean blnFlag = false;
		try {

			for (int i = 1; i <= iExpectedWaitTime; i++) {

				int iSize = MultipleSlowResources.size();
				Thread.sleep(2000);

				if (!(iSize == 0)) {
					if (SlowResources.isDisplayed()) {
						blnFlag = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			etest.log(Status.INFO, e);
		}

		if (blnFlag) {
			etest.log(Status.PASS, "I can see the selected object in UI");
		} else {
			System.out.println("Fail");
			etest.log(Status.FAIL, "I can not see the selected object in UI");
		}

	}

}
