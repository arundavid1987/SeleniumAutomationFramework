package com.component.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PaginationPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;

	public PaginationPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		waittime = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public PaginationPage initElements() {
		return PageFactory.initElements(this.driver, PaginationPage.class);
	}

	@FindBy(xpath = "#example_paginate>span>a")

	private WebElement paginationSize;

	public void paginationSize() throws Exception {

		int paginationSize = driver.findElements(By.cssSelector("#example_paginate>span>a")).size();

		List<String> names = new ArrayList<String>();

		for (int i = 1; i <= paginationSize; i++) {
			String paginationSelector = "#example_paginate>span>a:nth-child(" + i + ")";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			List<WebElement> namesElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));

			for (WebElement namesElement : namesElements) {
				names.add(namesElement.getText());

			}
		}

		for (String name : names) {
			System.out.println(name);
		}

		int totalNames = names.size();
		System.out.println("Total Number of names: " + totalNames);
		String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total Number of Displayed Names Count:" + displayedCount);
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		Thread.sleep(5000);
	}

}
