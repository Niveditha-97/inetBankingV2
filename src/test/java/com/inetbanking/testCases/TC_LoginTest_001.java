package com.inetbanking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass // baseclass contains common v n methods for all tc
{

	@Test
	public void loginTest() throws InterruptedException

	{

		 
		//.get(prop.getProperty("url")); // url is in baseclass as variable - taken to baseclass after invoking browser
		// This test needs page 1 elements so create a object for that class and access
		// those page element-action methods
		logger.debug("Application got opened");
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(3000);
		lp.setUsername(prop.getProperty("username"));
		logger.info("username entered");
		lp.setPassword(prop.getProperty("password"));
		logger.debug("password entered");
		lp.clickSubmit();

		if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) 
		{
			logger.info("Success: We are in correct page");
			Assert.assertTrue(true);
		} else
		{
			logger.error("Error");
			Assert.assertTrue(false);
		}
		

	}

}
