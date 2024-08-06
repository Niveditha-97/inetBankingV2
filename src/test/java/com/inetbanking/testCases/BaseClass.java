package com.inetbanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	//common variables with value 
	
	String url ;
	String username ;
	String password ;
	static WebDriver driver;      // this is common but make it static since it is common among all its objects and can have one memoryspace
	public Logger logger;
	public Properties prop;
	
	//PREREQUISTE FOR ALL TC 
	//SETUP
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws IOException 
	{
		
		//String browser = "Chrome";
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\test_user\\Desktop\\Exception\\inetBankingV1\\Configurations\\config.properties");
		prop.load(file);
		logger=LogManager.getLogger(this.getClass());
	
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();            //since driver is defined already just intsaniate the driver
	   }
	else 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	   }
	

		driver.get(prop.getProperty("url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
