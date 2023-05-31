package co.in.amazon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonPage {
	
	 public WebDriver driver;
	 public AmazonPage(WebDriver driver) {
		 this.driver=driver;
	 }
 
	 public AmazonPage initElements() {
		 
			return PageFactory.initElements(this.driver, AmazonPage.class);
		}
	 
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement txtSearchBox;
 
 
	
	 public void searchProduct(String searchkey,String assertkey) throws Exception{
			 
			txtSearchBox.sendKeys(searchkey);
			txtSearchBox.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			String currnttitle= driver.getTitle();
			System.out.println("currnttitle "+currnttitle);
			Assert.assertTrue(currnttitle.contains(assertkey));			 
				Thread.sleep(3000);
 
		}

}
