package com.aspire.tests;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aspire.Pages.AspireAppHomePage;
import com.aspire.Pages.AspireAppInventoryPage;
import com.aspire.Pages.AspireAppLoginPage;
import com.aspire.Pages.AspireAppManufacturingPage;
import com.aspire.SystemUtilities.LogsUtil;
import com.aspire.baseframework.ChromeBrow;
import com.aspire.baseframework.FireFoxBrow;
import com.aspire.baseframework.FrameworkInitialize;
import com.aspire.baseframework.NoCorrectDriverFoundException;
import com.aspire.baseframework.SafariBrow;


public class ProblemTestCase extends FrameworkInitialize{
	AspireAppLoginPage login = new AspireAppLoginPage();	
	AspireAppHomePage home = new AspireAppHomePage();
	AspireAppInventoryPage inventory = new AspireAppInventoryPage();
	AspireAppManufacturingPage manufacturing = new AspireAppManufacturingPage();
	
	@BeforeTest
	public  void kickStartProject() throws InterruptedException {
	try {	String BrowserName = reader.getBrowserType();
		LogsUtil.info("Browser Type : " + BrowserName.toLowerCase());
		System.out.println("Lower case "+BrowserName.toLowerCase());
		
		if(BrowserName.equalsIgnoreCase("firefox")) {
	Driver = FireFoxBrow.getFirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("chrome")) {

			System.out.println(var_OSName+"__________________var_OSName");
			Driver = ChromeBrow.getChromeDriver(var_OSName);
			System.out.println("Entered this loop");
		}
		else if(BrowserName.equalsIgnoreCase("safari")) {
		
			Driver = SafariBrow.getSafariDriver();
		}
		Driver.get(reader.getWebsite());
		Driver.manage().timeouts().pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		login.Login(reader.getUserName(),reader.getPassword());
	}
	catch(Exception e){
		throw new NoCorrectDriverFoundException(" Driver Not Found : " + reader.getBrowserType());

	}
	}

	
		
	
	@AfterMethod
	
	public void thishasToruntoresetwebSiteStatus()
	{
		inventory.gobacktoHomeMenu();
		
	}
	
	@Test(dataProvider = "excelData", dataProviderClass = FrameworkInitialize.class)
	public void RunEndtoEndTestCase(String ProductName, String Quantity, String LineProductName, String LineQuantity) throws InterruptedException
	
	{
		
		home.clickInventory();
		inventory.createNewProduct(ProductName, Quantity);
		inventory.gobacktoHomeMenu();
		home.clickManufacturing();
		
		
		manufacturing.CreateManufacturingorder( ProductName,  Quantity,  LineProductName, LineQuantity);
		manufacturing.ValidateOrder();
		Thread.sleep(10000);
	}

}
