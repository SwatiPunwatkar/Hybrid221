package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="email")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//Button")
	private WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements( driver,this);
		
		
	}
	
	public void LoginToApplication(String username,String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		LoginBtn.click();
	}

}
