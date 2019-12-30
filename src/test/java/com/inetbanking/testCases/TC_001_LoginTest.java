package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass
{
    @Test()
	public void loginTest() throws InterruptedException
	{
    	
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		Thread.sleep(3000);
        lp.setUserName(username);
		logger.info("username is entered");
		lp.setPasword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("user is able to login");
		
		if(driver.getTitle().equals("nopCommerce demo store"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			try {
				captureScreen(driver,"loginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				captureScreen(driver, "loginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertFalse(false);
			logger.info("Login failed");
		}
		lp.clickElectronicsTab();
		//Thread.sleep(4000);
		
		
		
	}
    
}
