package com.computech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computech.utilites.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='txtUsername']") WebElement txtUsername;
	@FindBy(how=How.XPATH, using="//input[@id='txtPassword']") WebElement txtPasswd;
	@FindBy(how=How.XPATH, using="//input[@id='btnLogin']") WebElement btnLogin;
	
	public void typeUsername() {
		
		txtUsername.sendKeys("Admin");
	}
	public void typePassword() {
	
		txtPasswd.sendKeys("admin123");
	}
	public void clickOnLogin() {
		
		btnLogin.click();
	}
	
	public void loginToApplication() {
		txtUsername.sendKeys("Admin");
		txtPasswd.sendKeys("admin123");
		btnLogin.click();
	}
	public void loginToApplication(String uName, String pwd) {
		Utility.highLightElement(driver, txtUsername);
		txtUsername.sendKeys(uName);
		Utility.highLightElement(driver, txtPasswd);
		txtPasswd.sendKeys(pwd);
		Utility.highLightElement(driver, btnLogin);
		btnLogin.click();
	}
	/*
	 public void loginToApplication(String uName, String pwd) {
		txtUsername.sendKeys(uName);
		txtPasswd.sendKeys(pwd);
		btnLogin.click();
	}
	 */
}
