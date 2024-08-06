package com.inetbanking.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test
	public void login()
	{
		
	}
	
	@DataProvider(name = "logindata")
	public void getData() 
	{
		String path = System.getProperty("user.dir")+"";   // path of test data in excel
		//we should use excel utils java
		int rownum = ExcelUtility.
		
	}

	

}
