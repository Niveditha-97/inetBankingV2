package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage 
{
	//ChromeDriver driver = new ChromeDriver();
	
	//If we use it like this we can't use driver  so get value from test using parameterized constructor an this keyword or diff name
	//CONSTRUCTOR
	WebDriver ldriver;           
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//LOCATORS
	
	@FindBy(name ="uid")
	WebElement txtusername;
	
	@FindBy(xpath="//td/input[@name ='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//td/input[@name ='btnLogin']")
	WebElement btnlogin;
	
	
	//ACTION METHODS FOR ELEMENTS
	
	public void setUsername(String uname)    // since action is sendkeys we should pass that as parameter to give input
	{
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)    // since action is sendkeys we should pass that as parameter to give input
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit()    // just action so no parameter
	{
		btnlogin.click();
	}
	
	

}
