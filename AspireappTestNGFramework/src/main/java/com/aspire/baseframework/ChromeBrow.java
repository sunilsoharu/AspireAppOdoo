package com.aspire.baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aspire.SystemUtilities.PropertyReader;


public class ChromeBrow {

protected static   PropertyReader reader = new PropertyReader();
public static  WebDriver driver;
	public static WebDriver getChromeDriver(String OSName){
		System.out.println(OSName.toLowerCase());
		if(OSName.toLowerCase().indexOf("win") >= 0){
			System.out.println("Windows Chrome : "+reader.getBrowserType());
			System.out.println("Found Chrome : "+reader.getChromeDriverPath());
		System.setProperty("webdriver.chrome.driver", reader.getChromeDriverPath());
		  driver = new ChromeDriver();
		
		}
		else if(OSName.toLowerCase().indexOf("mac") >=0) {
		System.out.println(OSName.toLowerCase());
			//System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		 driver = new ChromeDriver();
		
		}
		if(driver==null)
		System.out.println("has null value");
		else {System.out.println(driver.toString());}
		return  driver;
		
	}
}
