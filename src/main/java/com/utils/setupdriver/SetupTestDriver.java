package com.utils.setupdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SetupTestDriver {

	private WebDriver driver = null;
    private String browser = null;
    private String baseUrl = null;
    
  
    
    

    public SetupTestDriver(String browser, String baseUrl) throws Exception {
        this.browser = browser;
  
        this.baseUrl = baseUrl;
   		switch (this.browser.toLowerCase()) {

	    		case "chrome":
	    			ChromeOptions  options = new ChromeOptions();
	    			options.addArguments("--disable-notifications");
	    			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	    			this.driver = new ChromeDriver(options);				
	    			break;

	    		case "firefox":
	    			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
	    			this.driver = new FirefoxDriver();
	    			break;

	    		case "ie":
	    			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\drivers\\IEDriverServer.exe");
	    			this.driver = new InternetExplorerDriver();
	    			break;

	    		default:
	    			new RuntimeException("Unsupported Browser type");
	    			break;
	    		}
 
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(baseUrl);

    }
    
    
    public String takeScreenshots(WebDriver driver,String methodName,String folderpath) throws Exception {		 
		 String path=folderpath+"\\"+methodName+".jpg";		 
		 File src = ((TakesScreenshot)  driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));			
			return path;
	    }
    public SetupTestDriver() {
    	
    }
   

    public String getBrowser() {
        return this.browser;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    
    public WebDriver getDriver() {
        return this.driver;
    }
	
    

}
