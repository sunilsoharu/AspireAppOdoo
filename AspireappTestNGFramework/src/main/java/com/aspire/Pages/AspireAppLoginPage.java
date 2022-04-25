package com.aspire.Pages;

import org.openqa.selenium.By;
import com.aspire.WebPageUtilities.PageElementUtil;
import com.aspire.baseframework.FrameworkInitialize;

public class AspireAppLoginPage extends FrameworkInitialize{
	

	PageElementUtil pgUtil = new PageElementUtil();
	By input_txt_Username = By.xpath("//input[@id='login']");
	By input_txt_Password = By.xpath("//input[@id='password']");
	By btn_login = By.xpath("//button[@type='submit']");
	

	public void Login(String UserName, String Password) throws InterruptedException
	{
		System.out.println("Executing the Test Method");
		
		//Driver.findElement(input_txt_Username).sendKeys(reader.getUserName());
		pgUtil.setText(input_txt_Username, UserName);
	
		pgUtil.setText(input_txt_Password, Password );
		pgUtil.performClick(btn_login);
		
	}

	

	
	
}
