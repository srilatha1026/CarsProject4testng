package com.ipivot.CarsProject.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ipivot.CarsProject.Utilities.PropertyOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	PropertyOperations propOps1 = new PropertyOperations();
	
	WebDriver driver;
	
	public WebDriver LaunchandNavigateBrowser() throws Exception {
		String browser =propOps1.getPropertyValueByKey("browser");
		String url = propOps1.getPropertyValueByKey("url");
		if(browser== null||browser=="") {
			throw new Exception("Browser value not set in properties file");
		}
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			throw new Exception("Browser should be chrome or internet explorer or firefox");
		}
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
}
