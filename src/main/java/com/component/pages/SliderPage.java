package com.component.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hm.selenium.ReusableComponents;

public class SliderPage {

	public WebDriver driver;
	 
	public SliderPage(WebDriver driver) {
		this.driver = driver;
	}

	public SliderPage initElements() {

		return PageFactory.initElements(this.driver, SliderPage.class);
	}

	@FindBy(xpath = "//*[@type='range']")
	private WebElement slider;

	public void slideElement() throws Exception {

		Thread.sleep(6000);

		System.out.println(slider.getSize());
		System.out.println(slider.getSize().getWidth());
		System.out.println(slider.getLocation().getX());
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		builder.moveToElement(slider).click()
				.dragAndDropBy(slider, slider.getLocation().getX() + slider.getSize().getWidth(), 0).build().perform();

		String currnttitle = driver.getTitle();
		System.out.println("currnttitle " + currnttitle);

		Thread.sleep(3000);

	}

	public static int GetPixelsToMove(WebElement Slider, long Amount, long SliderMax, long SliderMin) {
		int pixels = 0;
		double tempPixels = Slider.getSize().getWidth();
		tempPixels = tempPixels / (SliderMax - SliderMin);
		tempPixels = tempPixels * (Amount - SliderMin);
		// pixels = Convert.ToInt32(tempPixels);
		pixels = (int) tempPixels;
		return pixels;
	}

	public void slideElement2() throws Exception {

		Thread.sleep(6000);
		Actions SliderAction = new Actions(driver)

		;
		System.out.println(slider.getSize().getWidth());
		System.out.println(slider.getSize().getWidth() / 2);
		System.out.println(GetPixelsToMove(slider, 75, 100, 0));

		SliderAction.clickAndHold(slider).moveByOffset((-(int) slider.getSize().getWidth() / 2), 0)
				.moveByOffset(GetPixelsToMove(slider, 50, 100, 0), 0).release().perform();

		Thread.sleep(6000);

	}

	public void slideElement(int amount) throws Exception {

		Thread.sleep(6000);
		Actions SliderAction = new Actions(driver)

		;
		System.out.println(slider.getSize().getWidth());
		System.out.println(slider.getSize().getWidth() / 2);
		System.out.println(GetPixelsToMove(slider, 75, 100, 0));

		SliderAction.clickAndHold(slider).moveByOffset((-(int) slider.getSize().getWidth() / 2), 0).release().perform();

		Thread.sleep(6000);

		for (int i = 0; i < amount; i++) {

			slider.sendKeys(Keys.ARROW_RIGHT);

		}

	}

}
