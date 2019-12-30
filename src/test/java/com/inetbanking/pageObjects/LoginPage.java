package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath ="//a[@class='ico-login']")
	WebElement login;
	
	@FindBy(name ="Email")
	WebElement txtUserName;
	
	@FindBy(name ="Password")
	WebElement txtPassword;
	
	@FindBy(xpath ="//input[@class='button-1 login-button']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]")
	WebElement electronics;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logout;
	
	
	
	public void clickLogin()
	{
		login.click();
	}
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
		
	}
	
	public void setPasword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickElectronicsTab()
	{
		electronics.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
	
	
}
